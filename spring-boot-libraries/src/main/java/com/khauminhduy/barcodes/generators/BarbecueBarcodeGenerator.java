package com.khauminhduy.barcodes.generators;

import java.awt.Font;
import java.awt.image.BufferedImage;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

public class BarbecueBarcodeGenerator {

	private static final Font BARCODE_TEXT_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

	public static BufferedImage generateEAN13BarcodeImage(String barcodeText) throws BarcodeException, OutputException {
		Barcode barcode = BarcodeFactory.createEAN13(barcodeText);
		barcode.setFont(BARCODE_TEXT_FONT);
		barcode.setDrawingText(false);
		barcode.setDrawingQuietSection(false);
		return BarcodeImageHandler.getImage(barcode);
	}

	public static BufferedImage generateUPCABarcodeImage(String barcodeText) throws BarcodeException, OutputException {
		Barcode barcode = BarcodeFactory.createUPCA(barcodeText);
		barcode.setFont(BARCODE_TEXT_FONT);
		barcode.setResolution(400);
		barcode.setDrawingText(false);
		barcode.setDrawingQuietSection(false);
		return BarcodeImageHandler.getImage(barcode);
	}

	public static BufferedImage generateCode128BarcodeImage(String barcodeText) throws BarcodeException, OutputException {
		Barcode barcode = BarcodeFactory.createCode128(barcodeText);
		barcode.setFont(BARCODE_TEXT_FONT);
		barcode.setDrawingText(false);
		barcode.setDrawingQuietSection(false);
		return BarcodeImageHandler.getImage(barcode);
	}

	public static BufferedImage generatePDF417BarcodeImage(String barcodeText) throws BarcodeException, OutputException {
		Barcode barcode = BarcodeFactory.createPDF417(barcodeText);
		barcode.setFont(BARCODE_TEXT_FONT);
		barcode.setDrawingText(false);
		barcode.setDrawingQuietSection(false);

		return BarcodeImageHandler.getImage(barcode);
	}

}
