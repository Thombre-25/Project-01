package org.kpi.pdf;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class PageFooter implements IEventHandler {

	private Document doc;
	
	public PageFooter(Document doc) {
		this.doc = doc;
	}

	@Override
	public void handleEvent(Event event) {

		PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
		Rectangle pageSize = docEvent.getPage().getPageSize();
		PdfDocument pdfDoc = docEvent.getDocument();
		PdfPage page = docEvent.getPage();
		PdfCanvas pdfCanvas = new PdfCanvas(page);
		pdfCanvas.roundRectangle(20, 15, 560, 40, 2);
		pdfCanvas.setFillColor(new DeviceRgb(75, 75, 75));
		pdfCanvas.fill();

		// add footer text
		Paragraph para1 = new Paragraph("www.fortifiedhealthsecurity.com");
		para1.setFixedPosition(230, 25, 200);
		para1.setFontColor(Color.WHITE);
		para1.setFontSize(11);

		// add footer page count
		Paragraph para2 = new Paragraph("Page "+doc.getPdfDocument().getPageNumber(page));
		para2.setFixedPosition(530, 25, 200);
		para2.setFontColor(Color.WHITE);
		para2.setFontSize(7);
		
		Canvas canvas = new Canvas(pdfCanvas, pdfDoc, pageSize);
		canvas.add(para1);
		canvas.add(para2);
		canvas.close();
	}

}
