/*******************************************************************************
 * Copyright 2014 Questing Software
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
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
