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

package com.ephesoft.dcma.da.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ephesoft.dcma.core.model.common.AbstractChangeableEntity;

/**
 * Entity class for module_plugin.
 * 
 * @author Ephesoft
 * @version 1.0
 * @see com.ephesoft.dcma.core.model.common.AbstractChangeableEntity
 */
@Entity
@Table(name = "module_plugin")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
public class ModulePlugin extends AbstractChangeableEntity {

	/**
	 * serialVersionUID long.
	 */
	private static final long serialVersionUID = -8801340830295935352L;

	/**
	 * module Module.
	 */
	@OneToOne
	@JoinColumn(name = "module_id", nullable = false)
	private Module module;

	/**
	 * plugin Plugin.
	 */
	@OneToOne
	@JoinColumn(name = "plugin_id", nullable = false)
	private Plugin plugin;

	/**
	 * orderNumber int.
	 */
	@Column(name = "order_number")
	private int orderNumber;

	/**
	 * To get Module.
	 * @return Module
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * To set Module.
	 * @param module Module
	 */
	public void setModule(Module module) {
		this.module = module;
	}

	/**
	 * To get plugin.
	 * @return Plugin
	 */
	public Plugin getPlugin() {
		return plugin;
	}

	/**
	 * To set plugin.
	 * @param plugin Plugin
	 */
	public void setPlugin(Plugin plugin) {
		this.plugin = plugin;
	}

	/**
	 * To get Order Number.
	 * @return int
	 */
	public int getOrderNumber() {
		return orderNumber;
	}

	/**
	 * To set Order Number. 
	 * @param orderNumber int
	 */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

}
