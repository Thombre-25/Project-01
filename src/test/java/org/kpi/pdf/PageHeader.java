package org.kpi.pdf;

import org.kpi.utility.DateUtil;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
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
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

public class PageHeader implements IEventHandler {

	@Override
	public void handleEvent(Event event) {

		PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
		Rectangle pageSize = docEvent.getPage().getPageSize();
		PdfDocument pdfDoc = docEvent.getDocument();
		PdfPage page = docEvent.getPage();
		PdfCanvas pdfCanvas = new PdfCanvas(page);
		pdfCanvas.roundRectangle(20, 750, 560, 80, 2);
		pdfCanvas.setFillColor(new DeviceRgb(75, 75, 75));
		pdfCanvas.fill();
		

		// add header image
		ImageData data = null;
		try {
			data = ImageDataFactory.create("src/imgs/CentralCommandDarkMode.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Image img = new Image(data);
		img.setHeight(55);
		img.setWidth(110);
		img.setFixedPosition(50, 765);

		// add header text
		Paragraph para = new Paragraph("Test Cases Report");
		para.setFontSize(15);
		para.setFixedPosition(230, 780, 200);
		para.setFontColor(new DeviceRgb(0, 190, 165));
		
		//add Date in header
		Paragraph date = new Paragraph("Date : "+DateUtil.getCurrentDate());
		date.setFontSize(10);
		date.setFixedPosition(480, 750, 200);
		date.setFontColor(Color.LIGHT_GRAY);
		
		Canvas canvas = new Canvas(pdfCanvas, pdfDoc, pageSize);
		canvas.add(img);
		canvas.add(para);
		canvas.add(date);
		canvas.close();
	}

}
