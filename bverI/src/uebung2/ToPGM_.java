package uebung2;

import ij.*;
import ij.process.*;
import ij.plugin.filter.*;
import ij.gui.*;
import ij.io.*;

import java.io.*;

public class ToPGM_ implements PlugInFilter{
	ImagePlus imp;

	public int setup(String arg, ImagePlus imp) {
		this.imp = imp;
		return DOES_8G + NO_CHANGES;
	}

	@Override
	public void run(ImageProcessor ip) {
		final int w = ip.getWidth();
		final int h = ip.getHeight();
		
		StringBuilder sb = new StringBuilder();
		int p;
		
		for (int v = 0; v < h; v++) {
			for (int u = 0; u < w; u++) {
				sb.append(ip.get(u, v) + " ");
			}
			sb.append("\n");
		}
		
		
		
		SaveDialog sd = new SaveDialog("Save image in HUF format", imp.getTitle(), ".pgm");
		if (sd.getFileName() != null) {
			imp.startTiming();
			try (BufferedWriter out = new BufferedWriter(new FileWriter(sd.getDirectory() + sd.getFileName()))){
				
				
				// write Header
				out.write("P2\n");
				out.write(w + " " + h + "\n");
				out.write("255\n");

				// write code
				out.write(sb.toString());

				// close file
				out.close();
				
				IJ.showMessage("PGM", "Image has been successfully saved.\n \n");
			} catch(Exception e){
				IJ.error("Huffman Encoder", e.getMessage());
			}
		}
		
	}
	
	
}
