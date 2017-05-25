package com.compassites.channels.service;

import org.springframework.stereotype.Service;

import com.compassites.channels.model.VCardXMLModel;
import com.thoughtworks.xstream.XStream;

@Service
public class XStreamParsingServiceImpl implements XStreamParsingService{

	@Override
	public String getDOBfromVcardXML(String xml) {
		XStream xstream = new XStream();
		xstream.alias("vCard", VCardXMLModel.class);
		VCardXMLModel vcardDetails = (VCardXMLModel) xstream.fromXML(xml);
		return vcardDetails.getDob();
	}

}
