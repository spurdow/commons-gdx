package com.gemserk.commons.svg.inkscape;

import org.w3c.dom.Element;

public abstract class SvgInkscapeImageHandler implements SvgElementHandler {

	@Override
	public void handle(SvgParser svgParser, SvgElement svgElement, Element element) {
		if (!(svgElement instanceof SvgInkscapeImage))
			return;
		SvgInkscapeImage svgImage = (SvgInkscapeImage) svgElement;
		handle(svgParser, svgImage, element);
	}

	@Override
	public void postHandle(SvgParser svgParser, SvgElement svgElement, Element element) {
		if (!(svgElement instanceof SvgInkscapeImage))
			return;
		SvgInkscapeImage svgImage = (SvgInkscapeImage) svgElement;
		postHandle(svgParser, svgImage, element);
	}

	protected void handle(SvgParser svgParser, SvgInkscapeImage svgImage, Element element) {
		
	}

	protected void postHandle(SvgParser svgParser, SvgInkscapeImage svgImage, Element element) {
		
	}

}