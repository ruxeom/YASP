package com.mamepato.juegospiratas.framework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface FileIO {
	
	public InputStream readAsset(String assetFileName) throws IOException;
	public InputStream readFile(String fileName) throws IOException;
	public OutputStream writeFile(String writeFile) throws IOException;

}
