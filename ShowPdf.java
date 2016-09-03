package com.practice.pdfgenerator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfObject;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Servlet implementation class ShowPdf
 */

public class ShowPdf extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public ShowPdf() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		   Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		   ServletOutputStream outputStream = response.getOutputStream();
		   try {
			   			
			PdfWriter.getInstance(document , outputStream);
		   
		    // we add some meta information to the document
			document.addAuthor("Test Pdf Preview"); 
			document.addSubject("This is the result of a Test."); 
			// we open the document for writing
			document.open(); 
		   
			document.add(new Paragraph("Hello world"));			
			response.addHeader("Content-Disposition", "inline;filename=abc.pdf");
			response.addHeader("Content-Type", "application/pdf");
			
			outputStream.flush();
									
		   } catch (DocumentException e) {
			 e.printStackTrace();
		   } catch (IOException e) {
			   
			   
		   }
		   
		   finally {
			   document.close();
			   outputStream.close();
		   }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

}
