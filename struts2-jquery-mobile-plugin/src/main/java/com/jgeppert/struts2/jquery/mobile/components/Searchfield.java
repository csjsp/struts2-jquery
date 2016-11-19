/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.jgeppert.struts2.jquery.mobile.components;

import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * A tag that creates an Seach Text Field.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * <pre>
 * &lt;sjm:searchfield
 * 	id=&quot;searchfield&quot;
 * 	name=&quot;searchfield&quot;
 * 	label=&quot;Search&quot;
 * /&gt;
 *
 * </pre>
 * <!-- END SNIPPET: example1 -->
 *
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */

@StrutsTag(name = "searchfield", tldTagClass = "com.jgeppert.struts2.jquery.mobile.views.jsp.ui.SearchfieldTag", description = "Renders a search text field", allowDynamicAttributes = true)
public class Searchfield extends org.apache.struts2.components.TextField implements ThemeableBean {

    public static final String TEMPLATE = "search";
    public static final String COMPONENT_NAME = Searchfield.class.getName();

    private static final String PARAM_DATA_THEME = "dataTheme";

    protected String dataTheme;

    public Searchfield(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        if (dataTheme != null) {
            addParameter(PARAM_DATA_THEME, findString(dataTheme));
        }
    }

    @Override
    @StrutsTagSkipInheritance
    public void setTheme(String theme) {
        super.setTheme(theme);
    }

    @Override
    public String getTheme() {
        return "mobile";
    }

    @StrutsTagAttribute(description = "Set the Search Field theme. e.g. a,b,c,d or e")
    public void setDataTheme(String dataTheme) {
        this.dataTheme = dataTheme;
    }

}
