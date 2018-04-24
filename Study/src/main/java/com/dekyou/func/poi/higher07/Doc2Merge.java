package com.dekyou.func.poi.higher07;

import java.util.List;

import org.apache.poi.xwpf.converter.xhtml.DefaultContentHandlerFactory;
import org.apache.poi.xwpf.converter.xhtml.IContentHandlerFactory;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.xml.sax.ContentHandler;

/**
 * @author GaoJing
 * @date 2018年4月21日
 * 
 */
public class Doc2Merge {
	
	private static final Doc2Merge instance = new Doc2Merge();
	
	//私有化构造函数
	private Doc2Merge() {}
	
	public Doc2Merge getInstance() {
		return instance;
	}
	
	public void doConvert(XWPFDocument document, XHTMLOptions options) {
        options = options != null ? options : XHTMLOptions.getDefault();
        // Create SAX content handler.
        IContentHandlerFactory factory = options.getContentHandlerFactory();
        if ( factory == null )
        {
            factory = DefaultContentHandlerFactory.INSTANCE;
        }
        ContentHandler contentHandler = factory.create( out, writer, options );
		this.convert(document);
	}
	
	
	public void convert(XWPFDocument document) {
		List<IBodyElement> bodyElements = document.getBodyElements();
		this.visitBodyElements(bodyElements);
	}

	
	public void visitBodyElements(List<IBodyElement> bodyElements) {
		 for ( int i = 0; i < bodyElements.size(); i++ )
	        {
	            IBodyElement bodyElement = bodyElements.get( i );
	            switch ( bodyElement.getElementType() )
	            {
	                case PARAGRAPH:
	                    XWPFParagraph paragraph = (XWPFParagraph) bodyElement;
	                    String paragraphStyleName = paragraph.getStyleID();
	                    boolean sameStyleBelow = false;

	                    visitParagraph( paragraph, i);
	                    break;
	                    
	                case TABLE:
//	                    previousParagraphStyleName = null;
	                    visitTable( (XWPFTable) bodyElement, i);
	                    break;
	                    
	                default:
	                	throw new Exception("未知word文档内容类型");
	                	break;
	            }
	        }
	}


	
	/**
	 * 遍历段落
	 * @param paragraph
	 * @param i
	 */
	public void visitParagraph(XWPFParagraph paragraph, int i) {
		
		
	}
	
	/**
	 * 遍历表格
	 * @param bodyElement
	 * @param i
	 */
	public void visitTable(XWPFTable bodyElement, int i) {
		
		
	}
	
	
	
}

