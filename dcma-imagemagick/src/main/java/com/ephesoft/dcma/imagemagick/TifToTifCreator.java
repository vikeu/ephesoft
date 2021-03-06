/********************************************************************************* 
* Ephesoft is a Intelligent Document Capture and Mailroom Automation program 
* developed by Ephesoft, Inc. Copyright (C) 2010-2012 Ephesoft Inc. 
* 
* This program is free software; you can redistribute it and/or modify it under 
* the terms of the GNU Affero General Public License version 3 as published by the 
* Free Software Foundation with the addition of the following permission added 
* to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED WORK 
* IN WHICH THE COPYRIGHT IS OWNED BY EPHESOFT, EPHESOFT DISCLAIMS THE WARRANTY 
* OF NON INFRINGEMENT OF THIRD PARTY RIGHTS. 
* 
* This program is distributed in the hope that it will be useful, but WITHOUT 
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
* FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more 
* details. 
* 
* You should have received a copy of the GNU Affero General Public License along with 
* this program; if not, see http://www.gnu.org/licenses or write to the Free 
* Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 
* 02110-1301 USA. 
* 
* You can contact Ephesoft, Inc. headquarters at 111 Academy Way, 
* Irvine, CA 92617, USA. or at email address info@ephesoft.com. 
* 
* The interactive user interfaces in modified source and object code versions 
* of this program must display Appropriate Legal Notices, as required under 
* Section 5 of the GNU Affero General Public License version 3. 
* 
* In accordance with Section 7(b) of the GNU Affero General Public License version 3, 
* these Appropriate Legal Notices must retain the display of the "Ephesoft" logo. 
* If the display of the logo is not reasonably feasible for 
* technical reasons, the Appropriate Legal Notices must display the words 
* "Powered by Ephesoft". 
********************************************************************************/ 

package com.ephesoft.dcma.imagemagick;

import java.io.File;
import java.io.IOException;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ephesoft.dcma.core.exception.DCMAApplicationException;
import com.ephesoft.dcma.core.threadpool.AbstractRunnable;

/**
 * This class is used for converting tif to pdf.
 * 
 * @author Ephesoft
 * @version 1.0
 * @see com.ephesoft.dcma.imagemagick.service.ImageProcessServiceImpl 
 */
public class TifToTifCreator extends AbstractRunnable {

	/**
	 * String to save source path.
	 */
	private final String sourcePath;
	/**
	 * String to save tiff image name.
	 */
	private final String tifImageName;

	/**
	 * An instance of Logger for proper logging in this file.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(TifToTifCreator.class);

	public TifToTifCreator(final String sourcePath, String tifImageName) {
		super();
		this.sourcePath = sourcePath;
		this.tifImageName = tifImageName;
	}

	/**
	 * This method is used to run the processing for conversion of tif to tif conversion. 
	 */
	@Override
	public void run() {
		LOGGER.info("Converting tif to tif.");
		String imagePath = sourcePath + File.separator + tifImageName;
		ConvertCmd cmd = new ConvertCmd();
		IMOperation imOper = new IMOperation();
		imOper.addImage();
		imOper.addImage();
		try {
			cmd.run(imOper, imagePath, imagePath);
			LOGGER.info("Succesfully completed conversion of tif to tif. File = " + imagePath);
		} catch (IOException e) {
			LOGGER.error("Error in convertring tif to pdf. File = " + imagePath, e.getMessage(), e);
			setDcmaApplicationException(new DCMAApplicationException(
					"Error in convertring tif to tif in createMultiPageFile plugin. File = " + imagePath, e));
		} catch (InterruptedException e) {
			LOGGER.error("Error in convertring tif to pdf. File = " + imagePath, e.getMessage(), e);
			setDcmaApplicationException(new DCMAApplicationException(
					"Error in convertring tif to tif in createMultiPageFile plugin. File = " + imagePath, e));
		} catch (IM4JavaException e) {
			LOGGER.error(e.getMessage(), e);
			setDcmaApplicationException(new DCMAApplicationException(
					"Error in convertring tif to tif in createMultiPageFile plugin. File = " + imagePath, e));
		}
	}
}
