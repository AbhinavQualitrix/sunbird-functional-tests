package org.apiPackage;

public class JsonAttributes {
	private String code;
	private String dataType;
	private String description;
	private Boolean editable;
	private Integer index;
	private String inputType;
	private String lable;
	
	//Made Changes
	private String label;
	
	private String name;
	private String placeholder;
	private Boolean required;
	private Boolean visible;
	private Object renderingHints;
	private Object validation;
	private Object range;

	
	//Made Changes
	public String getlabel() {
		return label;
	}
	public void setlabel(String label) {
		this.label = label;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getlable() {
		return lable;
	}

	public void setlable(String lable) {
		this.lable = lable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Object getRenderingHints() {
		return renderingHints;
	}

	public void setRenderingHints(Object renderingHints) {
		this.renderingHints = renderingHints;
	}

	public Object getValidation() {
		return validation;
	}

	public void setValidation(Object validation) {
		this.validation = validation;
	}

	public Object getRange() {
		return range;
	}

	public void setRange(Object range) {
		this.range = range;
	}

}
