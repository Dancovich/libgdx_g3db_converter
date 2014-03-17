package br.com.questingsoftware.libgdx.g3db.tests;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.questingsoftware.libgdx.g3db.G3DBConverter;

import com.badlogic.gdx.files.FileHandle;

public class ConvertG3DBTest {
	
	@Test
	public void convertModelTest(){
		try {
			URL filePath = ConvertG3DBTest.class.getResource("/model.g3dj");
			File file = new File(filePath.toURI());
			file = file.getParentFile();
			file = file.getAbsoluteFile();
			
			G3DBConverter converter = new G3DBConverter();
			FileHandle handle = new FileHandle(file);
			
			converter.convertFolder(handle, true);
			
			FileHandle newFile = handle.child("model.g3db");
			Assert.assertNotNull(newFile);
			Assert.assertTrue(newFile.exists());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@After
	public void removeFiles(){
		try {
			URL filePath = ConvertG3DBTest.class.getResource("/model.g3db");
			File file = new File(filePath.toURI());
			
			if (file.exists()){
				file.delete();
			}
		} catch (URISyntaxException e) {
		}
	}

}
