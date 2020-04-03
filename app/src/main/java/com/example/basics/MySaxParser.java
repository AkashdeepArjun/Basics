package com.example.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MySaxParser extends AppCompatActivity {
    TextView sax_output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sax_parser);
        sax_output=(TextView)findViewById(R.id.sax_output);
        SAXParserFactory saxfactory=SAXParserFactory.newInstance();
        try
        {
            SAXParser myparser=saxfactory.newSAXParser();
            DefaultHandler myhandler =new DefaultHandler(){
                boolean model=false;
                boolean cantransform=false;
                @Override
                public void startElement(String Uri,String ln,String qName, Attributes atts)
                {
                    if(qName.equalsIgnoreCase("model"))
                    {
                        model=true;

                    }
                    if(qName.equalsIgnoreCase("cantransform"))
                    {
                        cantransform=true;
                    }
                }
                public void endElement(String Uri,String lname,String qname)
                {

                }
                @Override
                public void characters(char[] datachars,int s,int e) throws SAXException
                {
                        if(model)
                        {
                            sax_output.setText("\n\nmodel: "+new String(datachars,s,e));
                            model=false;
                        }
                        if(cantransform)
                        {
                            sax_output.append("\n\n can transform: "+new String(datachars,s,e));
                            cantransform=false;
                        }
                }
            };
            InputStream is =getAssets().open("data.xml");
            myparser.parse(is,myhandler);
        }catch (Exception detective)
        {
            detective.printStackTrace();
        }
    }
}
