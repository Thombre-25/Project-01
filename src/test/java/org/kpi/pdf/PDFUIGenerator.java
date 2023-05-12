package org.kpi.pdf;

import java.util.List;
import java.util.Map;

import org.kpi.utility.DateUtil;
import org.testng.ITestResult;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class PDFUIGenerator {

	public static void generateCircles(Document doc, PdfDocument pdfDoc, PdfFont font, PdfPage page, int total,
			int passed, int failed, int skipped) {
		// add background to circles
		PdfCanvas rect = new PdfCanvas(page);
		rect.roundRectangle(50, 350, 500, 140, 10);
		rect.setFillColor(new DeviceRgb(242, 242, 242));
		rect.fill();

		// first big circle
		PdfCanvas canvas2 = new PdfCanvas(page);
		canvas2.circle(110, 410, 40);
		canvas2.setFillColor(new DeviceRgb(10, 83, 148));
		canvas2.fill();
		// first small circle
		PdfCanvas canvas3 = new PdfCanvas(page);
		canvas3.circle(110, 410, 25);
		canvas3.setFillColor(new DeviceRgb(240, 240, 240));
		canvas3.fill();

		// second big circle
		PdfCanvas canvas4 = new PdfCanvas(page);
		canvas4.circle(235, 410, 40);
		canvas4.setFillColor(new DeviceRgb(56, 118, 29));
		canvas4.fill();
		// second small circle
		PdfCanvas canvas5 = new PdfCanvas(page);
		canvas5.circle(235, 410, 25);
		canvas5.setFillColor(new DeviceRgb(240, 240, 240));
		canvas5.fill();

		// third big circle
		PdfCanvas canvas6 = new PdfCanvas(page);
		canvas6.circle(360, 410, 40);
		canvas6.setFillColor(new DeviceRgb(153, 0, 0));
		canvas6.fill();
		// third small circle
		PdfCanvas canvas7 = new PdfCanvas(page);
		canvas7.circle(360, 410, 25);
		canvas7.setFillColor(new DeviceRgb(240, 240, 240));
		canvas7.fill();

		// fourth big circle
		PdfCanvas canvas8 = new PdfCanvas(page);
		canvas8.circle(485, 410, 40);
		canvas8.setFillColor(new DeviceRgb(191, 144, 3));// 224, 181, 11
		canvas8.fill();
		// fourth small circle
		PdfCanvas canvas9 = new PdfCanvas(page);
		canvas9.circle(485, 410, 25);
		canvas9.setFillColor(new DeviceRgb(240, 240, 240));
		canvas9.fill();

		// add circle 1 heading
		Paragraph circle1 = new Paragraph("Total");
		circle1.setFont(font);
		circle1.setFontSize(12);
		circle1.setFixedPosition(95, 450, 100);
		circle1.setFontColor(Color.BLACK);
		doc.add(circle1);

		// add circle 2 heading
		Paragraph circle2 = new Paragraph("Passed");
		circle2.setFont(font);
		circle2.setFontSize(12);
		circle2.setFixedPosition(215, 450, 100);
		circle2.setFontColor(Color.BLACK);
		doc.add(circle2);

		// add circle 3 heading
		Paragraph circle3 = new Paragraph("Failed");
		circle3.setFont(font);
		circle3.setFontSize(12);
		circle3.setFixedPosition(345, 450, 100);
		circle3.setFontColor(Color.BLACK);
		doc.add(circle3);

		// add circle 4 heading
		Paragraph circle4 = new Paragraph("Skipped");
		circle4.setFont(font);
		circle4.setFontSize(12);
		circle4.setFixedPosition(465, 450, 100);
		circle4.setFontColor(Color.BLACK);
		doc.add(circle4);

		// add vertical line after circle 1
		PdfCanvas line1 = new PdfCanvas(page);
		line1.moveTo(175, 470);
		line1.lineTo(175, 370);
		line1.setFillColor(new DeviceRgb(75, 75, 75));
		line1.fill();

		// add vertical line after circle 2
		PdfCanvas line2 = new PdfCanvas(page);
		line2.moveTo(295, 470);
		line2.lineTo(295, 370);
		line2.setFillColor(new DeviceRgb(75, 75, 75));
		line2.fill();

		// add vertical line after circle 3
		PdfCanvas line3 = new PdfCanvas(page);
		line3.moveTo(420, 470);
		line3.lineTo(420, 370);
		line3.setFillColor(new DeviceRgb(75, 75, 75));
		line3.fill();

		// add text in first circle
		String totalValue = String.valueOf(total);
		char[] totalCharArray = totalValue.toCharArray();
		Paragraph circleText1 = new Paragraph(totalValue);
		circleText1.setFont(font);
		if(totalCharArray.length == 2) {
			circleText1.setFixedPosition(103, 400, 100);
		}
		else if(totalCharArray.length == 1) {
			circleText1.setFixedPosition(107, 400, 100);
		}
		else {
			circleText1.setFixedPosition(98, 400, 100);
		}
		circleText1.setFontColor(Color.BLACK);
		circleText1.setFontSize(13);
		doc.add(circleText1);

		// add text in second circle
		String passedValue = String.valueOf(passed);
		char[] passedCharArray = passedValue.toCharArray();
		Paragraph circleText2 = new Paragraph(passedValue);
		circleText2.setFont(font);
		if(passedCharArray.length == 2) {
			circleText2.setFixedPosition(228, 400, 100);
		}
		else if(passedCharArray.length == 1) {
			circleText2.setFixedPosition(233, 400, 100);
		}
		circleText2.setFontColor(Color.BLACK);
		circleText2.setFontSize(13);
		doc.add(circleText2);

		// add text in third circle
		String failedValue = String.valueOf(failed);
		char[] failedCharArray = failedValue.toCharArray();
		Paragraph circleText3 = new Paragraph(failedValue);
		circleText3.setFont(font);
		if(failedCharArray.length == 2) {
			circleText3.setFixedPosition(353, 400, 100);
		}
		else if(failedCharArray.length == 1) {
			circleText3.setFixedPosition(357, 400, 100);
		}
		circleText3.setFontColor(Color.BLACK);
		circleText3.setFontSize(13);
		doc.add(circleText3);

		// add text in fourth circle
		Paragraph circleText4 = new Paragraph(String.valueOf(skipped));
		circleText4.setFont(font);
		circleText4.setFixedPosition(482, 400, 100);
		circleText4.setFontColor(Color.BLACK);
		circleText4.setFontSize(13);
		doc.add(circleText4);
	}
	
	public static void generateDetailsTable(Document doc, PdfFont font, Map<String, String> map) {
		float[] columnWidths = { 100, 200};
		Table table = new Table(columnWidths);
		table.setMarginTop(77);
		table.setMarginLeft(15);
		table.setWidth(500);
		// table.setFixedPosition(50, 50, 500);
		Cell headerCell = new Cell(1, 2);
		headerCell.add(new Paragraph("Automation Details")).setFont(font).setFontSize(13).setFontColor(Color.WHITE)
				.setBackgroundColor(new DeviceRgb(10, 83, 148)).setTextAlignment(TextAlignment.CENTER);

		table.addHeaderCell(headerCell);

		for(String key : map.keySet()) {
			table.addCell(new Cell().setTextAlignment(TextAlignment.LEFT).setFontSize(10).setBackgroundColor(new DeviceRgb(242, 242, 242))
					.add(new Paragraph(key).setFontColor(Color.BLACK)));
			table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).setFontSize(10)
					.add(new Paragraph(map.get(key))));
		}

		doc.add(table);

	} // generateDetailsTable

	public static void generatePassedTable(Document doc, PdfFont font, List<ITestResult> list) {
		float[] columnWidths = { 200, 200, 200 };
		Table table = new Table(columnWidths);
		table.setMarginTop(180);
		table.setMarginLeft(15);
		table.setWidth(500);
		// table.setFixedPosition(50, 50, 500);
		Cell headerCell = new Cell(1, 3);
		headerCell.add(new Paragraph("Passed")).setFont(font).setFontSize(13).setFontColor(Color.WHITE)
				.setBackgroundColor(new DeviceRgb(56, 118, 29)).setTextAlignment(TextAlignment.CENTER);

		table.addHeaderCell(headerCell);

		for (int i = 0; i < 1; i++) {
			Cell[] cellArray = new Cell[] {
					new Cell().setBackgroundColor(new DeviceRgb(76, 138, 39)).add(new Paragraph("Time"))
							.setFontColor(Color.WHITE).setFont(font).setTextAlignment(TextAlignment.CENTER),
					new Cell().setBackgroundColor(new DeviceRgb(76, 138, 39)).add(new Paragraph("Module/Screen"))
							.setFontColor(Color.WHITE).setFont(font).setTextAlignment(TextAlignment.CENTER),
					new Cell().setBackgroundColor(new DeviceRgb(76, 138, 39)).add(new Paragraph("Test Case"))
							.setFontColor(Color.WHITE).setFont(font).setTextAlignment(TextAlignment.CENTER) };

			for (Cell cell : cellArray) {
				if (i == 0) {
					table.addHeaderCell(cell);
				} // if
			} // second for loop
		} // first for loop

		for (int i = 0; i < list.size(); i++) {
			table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).setFontSize(10)
					.add(new Paragraph(DateUtil.convertMillisToDate(list.get(i).getEndMillis()))));
			table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).setFontSize(10)
					.add(new Paragraph(list.get(i).getTestContext().getName())));
			table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).setFontSize(10)
					.add(new Paragraph(list.get(i).getMethod().getMethodName())));
		}

		doc.add(table);

	} // generatePassedTable

	public static void generateSecondPassedTable(Document doc, PdfFont font, List<ITestResult> list) {
		float[] columnWidths = { 200, 200, 200 };
		Table table = new Table(columnWidths);
		table.setMarginTop(80);
		table.setMarginLeft(15);
		table.setWidth(500);
		table.setMarginBottom(35);
		// table.setFixedPosition(50, 50, 500);
		Cell headerCell = new Cell(1, 3);
		headerCell.add(new Paragraph("Passed")).setFont(font).setFontSize(13).setFontColor(Color.WHITE)
				.setBackgroundColor(new DeviceRgb(56, 118, 29)).setTextAlignment(TextAlignment.CENTER);

		table.addHeaderCell(headerCell);

		for (int i = 0; i < 1; i++) {
			Cell[] cellArray = new Cell[] {
					new Cell().setBackgroundColor(new DeviceRgb(76, 138, 39)).add(new Paragraph("Time"))
							.setFontColor(Color.WHITE).setFont(font).setTextAlignment(TextAlignment.CENTER),
					new Cell().setBackgroundColor(new DeviceRgb(76, 138, 39)).add(new Paragraph("Module/Screen"))
							.setFontColor(Color.WHITE).setFont(font).setTextAlignment(TextAlignment.CENTER),
					new Cell().setBackgroundColor(new DeviceRgb(76, 138, 39)).add(new Paragraph("Test Case"))
							.setFontColor(Color.WHITE).setFont(font).setTextAlignment(TextAlignment.CENTER) };

			for (Cell cell : cellArray) {
				if (i == 0) {
					table.addHeaderCell(cell);
				} // if
			} // second for loop
		} // first for loop

		for (int i = 0; i < list.size(); i++) {
			table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).setFontSize(10)
					.add(new Paragraph(DateUtil.convertMillisToDate(list.get(i).getEndMillis()))));
			table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).setFontSize(10)
					.add(new Paragraph(list.get(i).getTestContext().getName())));
			table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).setFontSize(10)
					.add(new Paragraph(list.get(i).getMethod().getMethodName())));
		}

		doc.add(table);

	} // generateSecondPassedTable

	public static void generateFailedTable(Document doc, PdfFont font, List<ITestResult> list) {		
		float[] columnWidths = { 200, 200, 200 };
		Table table = new Table(columnWidths);
		table.setMarginTop(80);
		table.setMarginLeft(15);
		table.setWidth(500);
		table.setMarginBottom(35);
		// table.setFixedPosition(50, 50, 500);
		Cell headerCell = new Cell(1, 3);
		headerCell.add(new Paragraph("Failed")).setFont(font).setFontSize(13).setFontColor(Color.WHITE)
				.setBackgroundColor(new DeviceRgb(153, 0, 0)).setTextAlignment(TextAlignment.CENTER);

		table.addHeaderCell(headerCell);

		for (int i = 0; i < 1; i++) {
			Cell[] cellArray = new Cell[] {
					new Cell().setBackgroundColor(new DeviceRgb(160, 50, 50)).add(new Paragraph("Time"))
							.setFontColor(Color.WHITE).setFont(font).setTextAlignment(TextAlignment.CENTER),
					new Cell().setBackgroundColor(new DeviceRgb(160, 50, 50)).add(new Paragraph("Module/Screen"))
							.setFontColor(Color.WHITE).setFont(font).setTextAlignment(TextAlignment.CENTER),
					new Cell().setBackgroundColor(new DeviceRgb(160, 50, 50)).add(new Paragraph("Test Case"))
							.setFontColor(Color.WHITE).setFont(font).setTextAlignment(TextAlignment.CENTER) };

			for (Cell cell : cellArray) {
				if (i == 0) {
					table.addHeaderCell(cell);
				} // if
			} // second for loop
		} // first for loop

		for (int i = 0; i < list.size(); i++) {
			table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).setFontSize(10)
					.add(new Paragraph(DateUtil.convertMillisToDate(list.get(i).getEndMillis()))));
			table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).setFontSize(10)
					.add(new Paragraph(list.get(i).getTestContext().getName())));
			table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).setFontSize(10)
					.add(new Paragraph(list.get(i).getMethod().getMethodName())));
		}

		doc.add(table);

	} // generateFailedTable

	public static void generateSkippedTable(Document doc, PdfFont font, List<ITestResult> list) {
		float[] columnWidths = { 200, 200, 200 };
		Table table = new Table(columnWidths);
		table.setMarginTop(80);
		table.setMarginLeft(15);
		table.setWidth(500);
		table.setMarginBottom(35);
		// table.setFixedPosition(50, 50, 500);
		Cell headerCell = new Cell(1, 3);
		headerCell.add(new Paragraph("Skipped")).setFont(font).setFontSize(13).setFontColor(Color.WHITE)
				.setBackgroundColor(new DeviceRgb(191, 144, 3)).setTextAlignment(TextAlignment.CENTER);

		table.addHeaderCell(headerCell);

		for (int i = 0; i < 1; i++) {
			Cell[] cellArray = new Cell[] {
					new Cell().setBackgroundColor(new DeviceRgb(195, 184, 33)).add(new Paragraph("Time"))
							.setFontColor(Color.WHITE).setFont(font).setTextAlignment(TextAlignment.CENTER),
					new Cell().setBackgroundColor(new DeviceRgb(195, 184, 33)).add(new Paragraph("Module/Screen"))
							.setFontColor(Color.WHITE).setFont(font).setTextAlignment(TextAlignment.CENTER),
					new Cell().setBackgroundColor(new DeviceRgb(195, 184, 33)).add(new Paragraph("Test Case"))
							.setFontColor(Color.WHITE).setFont(font).setTextAlignment(TextAlignment.CENTER) };

			for (Cell cell : cellArray) {
				if (i == 0) {
					table.addHeaderCell(cell);
				} // if
			} // second for loop
		} // first for loop

		for (int i = 0; i < list.size(); i++) {
			table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).setFontSize(10)
					.add(new Paragraph(DateUtil.convertMillisToDate(list.get(i).getEndMillis()))));
			table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).setFontSize(10)
					.add(new Paragraph(list.get(i).getTestContext().getName())));
			table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).setFontSize(10)
					.add(new Paragraph(list.get(i).getMethod().getMethodName())));
		}

		doc.add(table);

	} // generateSkippedTable
	
} // class
