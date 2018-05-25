package com.dekyou.func.poi.higher07.self.copy.official;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLProperties;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHyperlink;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.apache.poi.xwpf.usermodel.XWPFSDT;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;

/**
 * @author GaoJing
 * @date 2018年4月22日
 * 
 */
public class XWPFDocumentMerge extends XWPFDocument {

	private CTDocument1 ctDocument;
	private XWPFDocument document;
	
	private Map<String,String> picIdMap = new HashMap<String,String>();
	private Map<String,String> styleIdMap =  new HashMap<String,String>();
	private ArrayList<String> styleIdList =  new ArrayList<String>();

	public XWPFDocumentMerge(XWPFDocument document) throws IOException {
		super(getPackage(document));
		onDocumentGet(document);
		this.document = document;
	}

	private static OPCPackage getPackage(XWPFDocument document) throws IOException {
		OPCPackage pkg = document.getPackage();
		return pkg;
	}

	// public XWPFParagraph copyParagraph( XWPFParagraph p1) {
	//
	// }

	public void copyDocument(XWPFDocument _document) throws InvalidFormatException, XmlException, IOException {
		XmlCursor cursor = _document.getDocument().getBody().newCursor();
		cursor.selectPath("./*");

		List<XWPFParagraph> XWPFParagraphList = document.getParagraphs();
		int paragraphSize = XWPFParagraphList.size();

		List<XWPFTable> XWPFTableList = document.getTables();
		int tableSize = XWPFTableList.size();

		for (XWPFTable t : XWPFTableList) {
			int tid = tableSize;
			String tyleiid = new String();
			if (t.getStyleID() != null) {
				tyleiid = t.getStyleID();
			}

			System.out.println("原来的表格Id为：" + tyleiid);
			if (!styleIdMap.containsKey(tyleiid)) {
				styleIdMap.put("B" + tyleiid, "newB" + tid);
			}
			t.setStyleID("newB" + tid);
			
			tid ++;
		}
		
		
		String xml2 = document.getDocument().getBody().xmlText();
	    CTBody makeBody2 = CTBody.Factory.parse(xml2.replace("rId", "RRIIDD"));
	    document.getDocument().getBody().set(makeBody2);
	   
	    picIdMap.put("RRIIDD", "rId");
		
		XmlCursor _cursor = ctDocument.getBody().newCursor();
		int j = 0;
		while (cursor.toNextSelection()) {
			XmlObject o = cursor.getObject();
			
			if (o instanceof CTP) {
				document.createParagraph();
				document.insertNewParagraph(_cursor);// 在表格位置插入一个新段落, 文档顶部重新变成了两个空段落
				XWPFParagraph p = new XWPFParagraph((CTP) o, this);
				document.setParagraph(p, paragraphSize++);// 将第1个段落设置成和第1个一样的段落
			
				if (p.getStyleID() != null) {
					styleIdMap.put(String.valueOf(j), p.getStyleID());
				}
			
				
			} else if (o instanceof CTTbl) {
				document.createTable();
				
				document.insertNewTbl(_cursor);
				XWPFTable t = new XWPFTable((CTTbl) o, this);
				
				String newTblStyle = "newA" + j;
				if (t.getStyleID() != null) {
					styleIdMap.put(t.getStyleID(), newTblStyle);
				}
				t.setStyleID(newTblStyle);
				
				
				document.setTable(tableSize++, t);
			} else if (o instanceof CTSdtBlock) {
				System.out.println("CTSdtBlock");
				XWPFSDT c = new XWPFSDT((CTSdtBlock) o, this);
				bodyElements.add(c);
				contentControls.add(c);
			}
			j++;
		}
		
		_cursor.dispose();
		cursor.dispose();
		String xml1 = document.getDocument().getBody().xmlText().replace("rId", "oldrId");
		

//		StringBuilder sb = new StringBuilder(xml1.substring(50000, xml1.length()));
//		System.out.println("line llllllllllllllll" + sb.indexOf("embed=\"rId"));
//		System.out.println(sb.substring(sb.indexOf("rId")-100, sb.indexOf("rId") + 100));
		
	    CTBody makeBody1 = CTBody.Factory.parse(xml1);
	    
	    
	    document.getDocument().getBody().set(makeBody1);
	    
		
		for (RelationPart rp : _document.getRelationParts()) {
			
			POIXMLDocumentPart p = rp.getDocumentPart();
			String relation = rp.getRelationship().getRelationshipType();
			
			if (relation.equals(XWPFRelation.STYLES.getRelation())) {
//				XWPFStyles oldStyles = (XWPFStyles) p;
				
				
				CTStyles newCtStyles = document.getStyle();
				int size = 0;
				
				if (newCtStyles != null) {
					
					size = newCtStyles.getStyleArray().length;
					
				}

				XWPFStyles newStyles = document.getStyles();
				CTStyles oldCtStyles_orginal = _document.getStyle();
				for (int jj = 0; jj < oldCtStyles_orginal.getStyleArray().length; jj++) {
					
					
					String oldStyleKey= oldCtStyles_orginal.getStyleArray()[jj].getStyleId();
					if (styleIdMap.containsKey("B" + oldStyleKey)) {
						CTStyle ct = oldCtStyles_orginal.getStyleArray()[jj];
						ct.setStyleId(styleIdMap.get("B" + oldStyleKey));
						System.out.println("改变样式");
						
						styleIdList.add(ct.xmlText());
					}
				}

				CTStyles ctStyles = CTStyles.Factory.newInstance();
				
				CTStyles oldCtStyles = _document.getStyle();
				for (int i = 0; i < oldCtStyles.getStyleArray().length; i++) {
					
					String oldStr = new String();
					String newStr = new String();
					if ( i == 0 ) {
						oldStr = "styleId=\"a\"";
						
					}else {
						oldStr = "styleId=\"a" + (i - 1) + "\"";
						
					}
					newStr = "styleId=\"a" + (size + i - 1) +"\"";
					
					String newStyle = new String();
					
					String oldStyleKey = oldStr.substring(9, oldStr.length()-1);
					if (styleIdMap.containsKey(oldStyleKey)) {
						String styleId = styleIdMap.get(oldStyleKey);
						newStr = "styleId=\"" + styleId +"\"";
						newStyle = oldCtStyles.getStyleArray()[i].xmlText().replace(oldStr, newStr);
						ctStyles.addNewStyle().set(CTStyle.Factory.parse(newStyle));
					}
				}
				
				for (String strStyle : styleIdList) {
					ctStyles.addNewStyle().set(CTStyle.Factory.parse(strStyle));
				}

				
//				InputStream is = oldStyles.getPackagePart().getInputStream();
//				StylesDocument  stylesDoc = StylesDocument.Factory.parse(is, DEFAULT_XML_OPTIONS);
				newStyles.setStyles(ctStyles);
				
				
			} else if (relation.equals(XWPFRelation.NUMBERING.getRelation())) {
//				XWPFNumbering oldNumbering = (XWPFNumbering) p;
//				XWPFNumbering newNumbering = document.createNumbering();
//				
//		        InputStream is = oldNumbering.getPackagePart().getInputStream();
//		        NumberingDocument   numberingDoc = NumberingDocument.Factory.parse(is, DEFAULT_XML_OPTIONS);
//		        CTNumbering  ctNumbering = numberingDoc.getNumbering();
//				newNumbering.setNumbering(ctNumbering);
//				
//				System.out.println("NUMBERING");
				
			} else if (relation.equals(XWPFRelation.FOOTER.getRelation())) {
//				relationshipType = XWPFRelation.FOOTER;
				System.out.println("footer");
				
			
			} else if (relation.equals(XWPFRelation.HEADER.getRelation())) {
//				relationshipType = XWPFRelation.HEADER;
				System.out.println("HEADER");
				
			} else if (relation.equals(XWPFRelation.COMMENT.getRelation())) {
//				relationshipType = XWPFRelation.COMMENT;
				System.out.println("COMMENT");
				
			} else if (relation.equals(XWPFRelation.SETTINGS.getRelation())) {
//				relationshipType = XWPFRelation.SETTINGS;
				System.out.println("SETTINGS");
//				document.addRelation(document.getRelationId(p), XWPFRelation.SETTINGS, p);
				
			
			} else if (relation.equals(XWPFRelation.IMAGES.getRelation())) {
				 XWPFPictureData picData = (XWPFPictureData) p;
				 
				 int format = picData.getPictureType();
				 
				 	
//			        List<XWPFPictureData> list = packagePictures.get(picData.getChecksum());
//			        if (list == null) {
//			            list = new ArrayList<XWPFPictureData>(1);
//			            packagePictures.put(picData.getChecksum(), list);
//			        }
//			        if (!list.contains(picData)) {
//			            list.add(picData);
//			        }
				 
//			       for (RelationPart rp : relations.values()) {
//			            if (rp.getDocumentPart() == part) {
//			                return rp.getRelationship().getId();
//			            }
//			        }
				 
				 String orginalId = rp.getRelationship().getId();
				 
//				 System.out.println("原来的id为" + orginalId);
				 String relId = document.addPictureData(picData.getData(), format);
//				 System.out.println("新的id为" + relId);
//				 if (relId.equals(orginalId)) {
					 picIdMap.put(orginalId, relId);
//				 }
				 
				 
//				 System.out.println("添加一张图片");
				
				
			} else if (relation.equals(XWPFRelation.GLOSSARY_DOCUMENT.getRelation())) {
//				relationshipType = XWPFRelation.GLOSSARY_DOCUMENT;
				System.out.println("GLOSSARY_DOCUMENT");
			}
			
		}
		
		System.out.println("111");
        try {
            Iterator<PackageRelationship> relIter =
                    getPackagePart().getRelationshipsByType(XWPFRelation.HYPERLINK.getRelation()).iterator();
            while (relIter.hasNext()) {
                PackageRelationship rel = relIter.next();
                hyperlinks.add(new XWPFHyperlink(rel.getId(), rel.getTargetURI().toString()));
            }
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
        
        System.out.println("开始替换图片ID");
        
        String xml = document.getDocument().getBody().xmlText();
        
        int iNum = 0;
        
        List<String> templ = new ArrayList<String>();
        StringBuilder sb1 = new StringBuilder(xml);
        String orgK = "embed=\"RRIIDD";
        String orgV = "embed=\"rId";
       for (Map.Entry<String, String> entry : picIdMap.entrySet()) {
    	   String key = entry.getKey().replace("rId", "oldrId");
    	  
//    	   String key1 = entry.getKey();
    	   
    	   
//    	   System.out.println("0000000000"+sb1.indexOf("embed=\"oldrId62"));
//    	   if (xml.contains(key)) {
//    		   xml = xml.replace(key, entry.getValue());
////    		   System.out.println("含有" + key);
//    		   iNum++;
//    	   }else if (sb1.indexOf(key1) != -1){
////    		   int start = sb1.indexOf(key1);
////    		   sb1.replace(start, start + key1.length(), entry.getValue());
////    		   xml = sb1.toString();
//    		  
//    		   templ.add(key);
//    	   }
    	   
    	   String newK = "embed=\"" + key;
    	   System.out.println("newkkkkkkkkkk"  + newK);
    	   

    	  
    	   int start = sb1.indexOf(newK);
    	 
    	   if (newK.equals(orgK)) {
    		   while(start != -1) {
    			   sb1 = sb1.replace(start, start +  newK.length(), orgV);
    			   start = sb1.indexOf(newK);
    			   System.out.println(start);
    		   }
    		   continue;
    	   }
    	   
    	   
    	   String newV = "embed=\"" + entry.getValue();
    	   System.out.println("newvvvvvvvvvv"  + newV);
    	   
    	   if (start != -1) {
    		   sb1 = sb1.replace(start, start +  newK.length(), newV);
    		  
    	   }
    	   
    	   
   		
       }
       
//       CTBody makeBody2 = CTBody.Factory.parse(xml2.replace("rId", "RRIIDD"));
       
       
       
       
       
       System.out.println("Map的大小为:" + picIdMap.size());
       System.out.println("替换的id个数为" + iNum);
       System.out.println("长度为:" + xml.length());
       
       for (String str : templ){
    	     System.out.println("aaaaaaa" + str);
       }
  
       
       
//       CTBody makeBody = CTBody.Factory.parse(xml);
       CTBody makeBody = CTBody.Factory.parse(sb1.toString());
       document.getDocument().getBody().set(makeBody);
//       FileOutputStream fos = new FileOutputStream("D://a.txt");
//       fos.write(xml.getBytes("UTF-8"));
//       fos.close();
//       String xml = document.getDocument().xmlText().replace(oldChar, newChar);
       
	}

	public void onDocumentGet(XWPFDocument document) {
		ctDocument = document.getDocument();
		POIXMLProperties.ExtendedProperties expProps = getProperties().getExtendedProperties();
		expProps.getUnderlyingProperties().setApplication(DOCUMENT_CREATOR);
	}

	public void write1(OutputStream stream) throws IOException {
		document.write(stream);
	}

}
