package com.khauminhduy.barcodes.generators;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.glxn.qrgen.javase.QRCode;

public class QRGenBarcodeGenerator {

	public static BufferedImage generateQRCodeImage(String barcodeText) throws IOException {
		ByteArrayOutputStream baos = QRCode.from(barcodeText).withSize(250, 250).stream();
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		return ImageIO.read(bais);
	}

}
