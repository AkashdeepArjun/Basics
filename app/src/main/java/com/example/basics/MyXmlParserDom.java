package com.example.basics;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
public class MyXmlParserDom extends AppCompatActivity {
    InputStream is;
    TextView myoutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_xml_parser_dom);
        myoutput=(TextView)findViewById(R.id.xml_output);
        try
        {
            is=getAssets().open("data.xml");
            DocumentBuilderFactory documentBuilderFactor=DocumentBuilderFactory.newInstance();
            DocumentBuilder mydocumentbuilder =documentBuilderFactor.newDocumentBuilder();
            Document mydocument=mydocumentbuilder.parse(is);
            Element element=mydocument.getDocumentElement();
            element.normalize();
            NodeList nodes=mydocument.getElementsByTagName("terminator");
            for(int i=0;i<nodes.getLength();i++)
            {
                Node node =nodes.item(i);
                if(node.getNodeType()==Node.ELEMENT_NODE)
                {

                    Element myelement =(Element)node;
                    myoutput.setText(myoutput.getText()+"\n\n name :"+getValue("model",myelement));
                    myoutput.setText(myoutput.getText()+"\n\n cantransform :"+getValue("cantransform",myelement));
                    myoutput.setText(myoutput.getText()+" \n\n ~ ~  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ");
                }
            }

        }catch (Exception inspector)
        {
            inspector.printStackTrace();
        }
    }
    private static String getValue(String tag,Element element)
    {
        String data;
        NodeList childNodes=element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node1=(Node)childNodes.item(0);
//                    node1.getNodeValue();
        data=node1.getNodeValue();
        return data;


    }


}
