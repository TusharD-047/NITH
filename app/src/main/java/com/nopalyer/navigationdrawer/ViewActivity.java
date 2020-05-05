package com.nopalyer.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import static android.os.Environment.*;


public class ViewActivity extends AppCompatActivity {

    private static final String TAG = "AdminActivity";
    private TextView name,faname,rolln,dobn,semtr,catg;
    Bundle bundle;
    private Button addpdf;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog mProgress;
    final long ONE_MEGABYTE = 1024*1024*5;
    private boolean DOCUMENT_OK = false, HAVE_IMG = false;
    private String email;
    private int Margin_left=120,Margin_top=120;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        bundle = getIntent().getExtras();
        UI();
        ActivityCompat.requestPermissions(ViewActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        mProgress = new ProgressDialog(ViewActivity.this);
        name.setText(bundle.get("Name").toString());
        faname.setText(bundle.get("Father's Name").toString());
        rolln.setText(bundle.get("Roll Number").toString());
        dobn.setText(bundle.get("Date Of Birth").toString());
        semtr.setText(bundle.get("Semester").toString());
        catg.setText(bundle.get("Category").toString());

        addpdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = bundle.get("Name").toString();
                mProgress.setMessage("Creating PDF...");
                mProgress.setCancelable(false);
                mProgress.show();
                if(generatePDF(email,bundle)) {
                    mProgress.dismiss();
                    Toast.makeText(ViewActivity.this,"PDF created", Toast.LENGTH_SHORT).show();
                    //openPDF(email);
                }else {
                    mProgress.dismiss();
                    Toast.makeText(ViewActivity.this,"PDF creation failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void  UI(){
        name = (TextView)findViewById(R.id.tvName);
        faname = (TextView)findViewById(R.id.tvFather);
        rolln = (TextView)findViewById(R.id.tvroll);
        dobn = (TextView)findViewById(R.id.tvDob);
        semtr = (TextView)findViewById(R.id.tvSem);
        catg = (TextView)findViewById(R.id.tvCategory);
        addpdf = (Button)findViewById(R.id.addpdf);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    private boolean generatePDF(String fname,Bundle student) {
        try {
            String fpath = Environment.getExternalStorageDirectory().getAbsolutePath() +"/vindroid" ;
            Log.e(TAG,"fpath:"+fpath);
            File dir = new File(fpath);
            if(!dir.exists()){
                //  dir.mkdirs();
                Log.e(TAG,"Result of Mkdir : "+dir.mkdirs());
            }else {
                Log.e(TAG,"Already Exists");
            }
            File file = new File(dir,fname+".pdf");
            //Toast.makeText(AdminActivity.this,"File created ", Toast.LENGTH_SHORT).show();
            Font bfBold12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
            Font bf12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Font f=new Font(Font.FontFamily.TIMES_ROMAN,25.0f,Font.NORMAL,BaseColor.BLACK);
            com.itextpdf.text.Rectangle rect = new com.itextpdf.text.Rectangle(PageSize.A4.getWidth(),PageSize.A4.getHeight());
            rect.setBorder(com.itextpdf.text.Rectangle.BOX);
            rect.setBorderWidth(2);
            Document document = new Document(PageSize.A4,Margin_left,Margin_left,Margin_top,Margin_top);
            PdfWriter writer =  PdfWriter.getInstance(document, new FileOutputStream(file.getAbsoluteFile()));
            PdfHeader event = new PdfHeader();
            writer.setPageEvent(event);
            List list = new List(List.UNORDERED);
            document.open();
            addmetadata(document);
            document.add(rect);
            addParagraph(document,"Name",f);
            addParagraph(document,"Father's Name",f);
            addParagraph(document,"Roll Number",f);
            addParagraph(document,"Date Of Birth",f);
            addParagraph(document,"Semester",f);
            addParagraph(document,"Category",f);


            //TODO Add other Details
            document.add(Chunk.NEWLINE);

            document.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (DocumentException e) {
            e.printStackTrace();
            return false;


        }
    }

    private void addParagraph(Document document,String content,Font f){
        try {
            document.add(new Paragraph(content+"     :   "+bundle.get(content),f));
        }catch(DocumentException e){
            Log.e("Document Error", "Failed adding"+content);
        }
    }

    private void addmetadata(Document document) {
        document.addTitle(bundle.get("Name")+"pdf");
        document.addSubject("Registration details");
        document.addAuthor("Students");
        document.addCreator("Students");
    }

    public static class PdfHeader extends PdfPageEventHelper {

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            try {
                Rectangle pageSize = document.getPageSize();
                ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("NATIONAL INSTITUTE OF TECHNOLOGY", FontFactory.getFont(FontFactory.COURIER, 18, Font.NORMAL)), pageSize.getLeft(275), pageSize.getTop(30), 0);
                ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Semester Registration Form", FontFactory.getFont(FontFactory.COURIER, 18, Font.NORMAL)), pageSize.getLeft(275), pageSize.getTop(70), 0);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
