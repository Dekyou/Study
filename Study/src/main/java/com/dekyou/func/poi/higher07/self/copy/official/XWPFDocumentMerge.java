package com.dekyou.func.poi.higher07.self.copy.official;

import static org.apache.poi.POIXMLTypeLoader.DEFAULT_XML_OPTIONS;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLProperties;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.apache.poi.xwpf.usermodel.XWPFSDT;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.NumberingDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument;

/**
 * @author GaoJing
 * @date 2018年4月22日
 * 
 */
public class XWPFDocumentMerge extends XWPFDocument {

	private CTDocument1 ctDocument;
	private XWPFDocument document;

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

		XmlCursor _cursor = ctDocument.getBody().newCursor();
		while (cursor.toNextSelection()) {
			XmlObject o = cursor.getObject();
			if (o instanceof CTP) {
				
				document.createParagraph();
				document.insertNewParagraph(_cursor);// 在表格位置插入一个新段落, 文档顶部重新变成了两个空段落
				XWPFParagraph p = new XWPFParagraph((CTP) o, this);
				document.setParagraph(p, paragraphSize++);// 将第1个段落设置成和第1个一样的段落
			
			} else if (o instanceof CTTbl) {
				document.createTable();
				document.insertNewTbl(_cursor);
				XWPFTable t = new XWPFTable((CTTbl) o, this);
				
				
//				int size = 1;
//				int space = 0;
//				t.setInsideHBorder(XWPFBorderType.SINGLE, size , space , null);
//				t.setInsideVBorder(XWPFBorderType.SINGLE, size , space , null);
				
				document.setTable(tableSize++, t);
				

			} else if (o instanceof CTSdtBlock) {
				
				XWPFSDT c = new XWPFSDT((CTSdtBlock) o, this);
				bodyElements.add(c);
				contentControls.add(c);
			}
		}
		
		_cursor.dispose();
//		int idx = 0;
		for (RelationPart rp : _document.getRelationParts()) {
			
			POIXMLDocumentPart p = rp.getDocumentPart();
			String relation = rp.getRelationship().getRelationshipType();
//			POIXMLRelation relationshipType = null;
			
			if (relation.equals(XWPFRelation.STYLES.getRelation())) {
//				relationshipType = XWPFRelation.STYLES;
				XWPFStyles oldStyles = (XWPFStyles) p;
				XWPFStyles newStyles = document.createStyles();
				
				InputStream is = oldStyles.getPackagePart().getInputStream();
				StylesDocument  stylesDoc = StylesDocument.Factory.parse(is, DEFAULT_XML_OPTIONS);
				newStyles.setStyles(stylesDoc.getStyles());
				
				
			} else if (relation.equals(XWPFRelation.NUMBERING.getRelation())) {
//				relationshipType = XWPFRelation.NUMBERING;
				XWPFNumbering oldNumbering = (XWPFNumbering) p;
				XWPFNumbering newNumbering = document.createNumbering();
				
		        InputStream is = oldNumbering.getPackagePart().getInputStream();
		        NumberingDocument   numberingDoc = NumberingDocument.Factory.parse(is, DEFAULT_XML_OPTIONS);
		        CTNumbering  ctNumbering = numberingDoc.getNumbering();
				newNumbering.setNumbering(ctNumbering);
			} else if (relation.equals(XWPFRelation.FOOTER.getRelation())) {
//				relationshipType = XWPFRelation.FOOTER;
			
			} else if (relation.equals(XWPFRelation.HEADER.getRelation())) {
//				relationshipType = XWPFRelation.HEADER;
				
			} else if (relation.equals(XWPFRelation.COMMENT.getRelation())) {
//				relationshipType = XWPFRelation.COMMENT;
				
			} else if (relation.equals(XWPFRelation.SETTINGS.getRelation())) {
//				relationshipType = XWPFRelation.SETTINGS;
				
			} else if (relation.equals(XWPFRelation.IMAGES.getRelation())) {
//				relationshipType = XWPFRelation.IMAGES;
				 XWPFPictureData picData = (XWPFPictureData) p;
				 int format = picData.getPictureType();
				 document.addPictureData(picData.getData(), format);
				
			} else if (relation.equals(XWPFRelation.GLOSSARY_DOCUMENT.getRelation())) {
//				relationshipType = XWPFRelation.GLOSSARY_DOCUMENT;
				
			}
			
		}
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
