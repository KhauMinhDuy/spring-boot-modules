package com.khauminhduy.barcodes.generators;

import java.awt.image.BufferedImage;

import org.krysalis.barcode4j.HumanReadablePlacement;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.pdf417.PDF417Bean;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.impl.upcean.UPCABean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

public class Barcode4jBarcodeGenerator {

	public static BufferedImage generateUPCABarcodeImage(String barcodeText) {
		UPCABean barcodeGenerator = new UPCABean();
		BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
		barcodeGenerator.setMsgPosition(HumanReadablePlacement.HRP_NONE);
		barcodeGenerator.generateBarcode(canvas, barcodeText);
		return canvas.getBufferedImage();
	}

	public static BufferedImage generateEAN13BarcodeImage(String barcodeText) {
		EAN13Bean barcodeGenerator = new EAN13Bean();
		BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
		barcodeGenerator.setMsgPosition(HumanReadablePlacement.HRP_NONE);
		barcodeGenerator.generateBarcode(canvas, barcodeText);
		return canvas.getBufferedImage();
	}

	public static BufferedImage generateCode128BarcodeImage(String barcodeText) {
		Code128Bean barcodeGenerator = new Code128Bean();
		BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
		barcodeGenerator.setMsgPosition(HumanReadablePlacement.HRP_NONE);
		barcodeGenerator.generateBarcode(canvas, barcodeText);
		return canvas.getBufferedImage();
	}

	public static BufferedImage generatePDF417BarcodeImage(String barcodeText) {
		PDF417Bean barcodeGenerator = new PDF417Bean();
		BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
		barcodeGenerator.setMsgPosition(HumanReadablePlacement.HRP_NONE);
		barcodeGenerator.generateBarcode(canvas, barcodeText);
		return canvas.getBufferedImage();
	}

}
