package com.ssp.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyCodeServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedImage bi = new BufferedImage(80, 40, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, 80, 40);
		
		g2d.setColor(Color.BLUE);
		String codes = "23456789abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ";
		
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 4; i++) {
			String str = codes.charAt(random.nextInt(codes.length()))+"";
			sb.append(str);
		}
		g2d.drawString(sb.toString(), 30, 20);
		req.getSession().setAttribute("verifycode", sb.toString());
		ImageIO.write(bi, "JPEG", resp.getOutputStream());
		
	}

	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
