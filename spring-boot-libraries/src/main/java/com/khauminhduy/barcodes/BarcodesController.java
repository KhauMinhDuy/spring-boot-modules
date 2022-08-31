package com.khauminhduy.barcodes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.khauminhduy.barcodes.generators.BarbecueBarcodeGenerator;
import com.khauminhduy.barcodes.generators.Barcode4jBarcodeGenerator;
import com.khauminhduy.barcodes.generators.QRGenBarcodeGenerator;
import com.khauminhduy.barcodes.generators.ZxingBarcodeGenerator;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

@RestController
@RequestMapping("/barcodes")
public class BarcodesController {

	// Barbecue library

	// http://localhost:8080/barcodes/barbecue/upca/12345678901
	@GetMapping(value = "/barbecue/upca/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<BufferedImage> barbecueUPCABarcode(@PathVariable("barcode") String barcode)
			throws BarcodeException, OutputException {
		return okResponse(BarbecueBarcodeGenerator.generateUPCABarcodeImage(barcode));
	}

	// localhost:8080/barcodes/barbecue/ean13/012345678901
	@GetMapping(value = "/barbecue/ean13/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<BufferedImage> barbecueEAN13Barcode(@PathVariable("barcode") String barcode) throws Exception {
		return okResponse(BarbecueBarcodeGenerator.generateEAN13BarcodeImage(barcode));
	}

	// localhost:8080/barcodes/barbecue/code128
	@PostMapping(value = "/barbecue/code128", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<BufferedImage> barbecueCode128Barcode(@RequestBody String barcode)
			throws BarcodeException, OutputException, IOException {
		BufferedImage generateCode128BarcodeImage = BarbecueBarcodeGenerator.generateCode128BarcodeImage(barcode);
		ImageIO.write(generateCode128BarcodeImage, "jpg", new File("output.jpg"));
		return okResponse(BarbecueBarcodeGenerator.generateCode128BarcodeImage(barcode));
	}

	// http://localhost:8080/barcodes/barbecue/pdf417
	@PostMapping(value = "/barbecue/pdf417", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<BufferedImage> barbecuePDF417Barcode(@RequestBody String barcode)
			throws BarcodeException, OutputException {
		return okResponse(BarbecueBarcodeGenerator.generatePDF417BarcodeImage(barcode));
	}

	// Barcode4j library

	@GetMapping(value = "/barcode4j/upca/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<BufferedImage> barcode4jUPCABarcode(@PathVariable("barcode") String barcode) {
		return okResponse(Barcode4jBarcodeGenerator.generateUPCABarcodeImage(barcode));
	}

	@GetMapping(value = "/barcode4j/ean13/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<BufferedImage> barcode4jEAN13Barcode(@PathVariable("barcode") String barcode) {
		return okResponse(Barcode4jBarcodeGenerator.generateEAN13BarcodeImage(barcode));
	}

	@PostMapping(value = "/barcode4j/code128", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<BufferedImage> barcode4jCode128Barcode(@RequestBody String barcode) throws IOException {
		BufferedImage generateCode128BarcodeImage = Barcode4jBarcodeGenerator.generateCode128BarcodeImage(barcode);
		ImageIO.write(generateCode128BarcodeImage, "jpg", new File("output.jpg"));
		return okResponse(generateCode128BarcodeImage);
	}

	@PostMapping(value = "/barcode4j/pdf417", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<BufferedImage> barcode4jPDF417Barcode(@RequestBody String barcode) {
		return okResponse(Barcode4jBarcodeGenerator.generatePDF417BarcodeImage(barcode));
	}

	// Zxing library

	@GetMapping(value = "/zxing/upca/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<BufferedImage> zxingUPCABarcode(@PathVariable("barcode") String barcode) {
		return okResponse(ZxingBarcodeGenerator.generateUPCABarcodeImage(barcode));
	}

	@GetMapping(value = "/zxing/ean13/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<BufferedImage> zxingEAN13Barcode(@PathVariable("barcode") String barcode) {
		return okResponse(ZxingBarcodeGenerator.generateEAN13BarcodeImage(barcode));
	}

	@PostMapping(value = "/zxing/code128", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<BufferedImage> zxingCode128Barcode(@RequestBody String barcode) {
		return okResponse(ZxingBarcodeGenerator.generateCode128BarcodeImage(barcode));
	}

	@PostMapping(value = "/zxing/pdf417", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<BufferedImage> zxingPDF417Barcode(@RequestBody String barcode) throws WriterException {
		return okResponse(ZxingBarcodeGenerator.generatePDF417BarcodeImage(barcode));
	}

	@PostMapping(value = "/zxing/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<BufferedImage> zxingQRCode(@RequestBody String barcode) throws WriterException {
		return okResponse(ZxingBarcodeGenerator.generateQRCodeImage(barcode));
	}

	// QRGen
	@PostMapping(value = "/qrgen/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<BufferedImage> qrgenQRCode(@RequestBody String barcode) throws IOException {
		return okResponse(QRGenBarcodeGenerator.generateQRCodeImage(barcode));
	}
	
	private ResponseEntity<BufferedImage> okResponse(BufferedImage image) {
		return new ResponseEntity<>(image, HttpStatus.OK);
	}

}
