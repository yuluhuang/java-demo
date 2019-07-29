///**
// * @Title
// * @Project java-demo
// * @Package com.yuluhuang.demo.htmlToWord
// * @Description
// * @author yoshikouamari
// * @date 2019-07-29 11:10
// * @version
// */
//package com.yuluhuang.demo.htmlToWord;
//
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.io.StringReader;
//import java.util.List;
//
//import com.lowagie.text.Document;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.html.simpleparser.HTMLWorker;
//import com.lowagie.text.html.simpleparser.StyleSheet;
//import com.lowagie.text.rtf.RtfWriter2;
///**
// *
// * @Description
// * @author yoshikouamari
// * @date 2019-07-29 11:10
// */
//public class ItextCreateRTF {
//    public static void main(String[] args) throws Exception
//
//    {
//        OutputStream out = new FileOutputStream("./11.doc");
//        Document document = new Document(PageSize.A4);
//        RtfWriter2.getInstance(document, out);
//        document.open();
//        Paragraph context = new Paragraph();
//        String htmlContent = "<h2>test</h2>";
//
//        StyleSheet ss = new StyleSheet();
//        List htmlList = HTMLWorker.parseToList(new StringReader(htmlContent), ss);
//        for (int i = 0 ; i < htmlList.size(); i++)
//        {
//            com.lowagie.text.Element e = (com.lowagie.text.Element) htmlList.get(i);
//            context.add(e);
//        }
//        document.open();
//        //设置页边距，上、下25.4毫米，即为72f，左、右31.8毫米，即为90f
//        document.setMargins(90f, 90f, 72f, 72f);
//        document.add(context);
//        document.close();
//        System.out.println("ok");
//    }
//}
