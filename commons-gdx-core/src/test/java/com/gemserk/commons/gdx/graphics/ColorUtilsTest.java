package com.gemserk.commons.gdx.graphics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.badlogic.gdx.graphics.Color;

public class ColorUtilsTest {

	@Test
	public void testConvertRed() {
		Color color = new Color();
		int rgba8888 = Color.rgba8888(1f, 0f, 0f, 0f);
		ColorUtils.rgba8888ToColor(color, rgba8888);
		assertEquals(1f, color.r, 0.01f);
		assertEquals(0f, color.g, 0.01f);
		assertEquals(0f, color.b, 0.01f);
		assertEquals(0f, color.a, 0.01f);
	}

	@Test
	public void testConvertGreen() {
		Color color = new Color();
		int rgba8888 = Color.rgba8888(0f, 1f, 0f, 0f);
		ColorUtils.rgba8888ToColor(color, rgba8888);
		assertEquals(0f, color.r, 0.01f);
		assertEquals(1f, color.g, 0.01f);
		assertEquals(0f, color.b, 0.01f);
		assertEquals(0f, color.a, 0.01f);
	}

	@Test
	public void testConvertBlue() {
		Color color = new Color();
		int rgba8888 = Color.rgba8888(0f, 0f, 1f, 0f);
		ColorUtils.rgba8888ToColor(color, rgba8888);
		assertEquals(0f, color.r, 0.01f);
		assertEquals(0f, color.g, 0.01f);
		assertEquals(1f, color.b, 0.01f);
		assertEquals(0f, color.a, 0.01f);
	}

	@Test
	public void testConvertAlpha() {
		Color color = new Color();
		int rgba8888 = Color.rgba8888(0f, 0f, 0f, 1f);
		ColorUtils.rgba8888ToColor(color, rgba8888);
		assertEquals(0f, color.r, 0.01f);
		assertEquals(0f, color.g, 0.01f);
		assertEquals(0f, color.b, 0.01f);
		assertEquals(1f, color.a, 0.01f);
	}

	@Test
	public void testConvertAllComponents() {
		Color color = new Color();
		int rgba8888 = Color.rgba8888(0.2f, 0.7f, 0.45f, 0.66f);
		ColorUtils.rgba8888ToColor(color, rgba8888);
		assertEquals(0.2f, color.r, 0.01f);
		assertEquals(0.7f, color.g, 0.01f);
		assertEquals(0.45f, color.b, 0.01f);
		assertEquals(0.66f, color.a, 0.01f);
	}
	
	@Test
	public void testConvertRgb888() {
		Color color = new Color();
		int rgb888 = Color.rgb888(0.2f, 0.7f, 0.45f);
		ColorUtils.rgb888ToColor(color, rgb888);
		assertEquals(0.2f, color.r, 0.01f);
		assertEquals(0.7f, color.g, 0.01f);
		assertEquals(0.45f, color.b, 0.01f);
	}
	
	@Test
	public void testConvertRgba444() {
		Color color = new Color();
		int rgba4444 = Color.rgba4444(0.2f, 0.4f, 0.6f, 0.8f);
		ColorUtils.rgba4444ToColor(color, rgba4444);
		assertEquals(0.2f, color.r, 0.01f);
		assertEquals(0.4f, color.g, 0.01f);
		assertEquals(0.6f, color.b, 0.01f);
		assertEquals(0.8f, color.a, 0.01f);
	}
	
	@Test
	public void testConvertRgba565() {
		Color color = new Color();
		int rgb565 = Color.rgb565(0.2f, 0.4f, 0.6f);
		ColorUtils.rgb565ToColor(color, rgb565);
		assertEquals(0.2f, color.r, 0.025f);
		assertEquals(0.4f, color.g, 0.025f);
		assertEquals(0.6f, color.b, 0.025f);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConvertFromHexString() {
		Color color = new Color();
		color.set(0.2f, 0.3f, 0.4f, 0.5f);
		ColorUtils.hexRGBToColor(color, "akldfkla;shfkla;");
	}
	
	@Test
	public void testConvertFromHexString2() {
		Color color = new Color();
		color.set(0.2f, 0.3f, 0.4f, 0.5f);
		ColorUtils.hexRGBToColor(color, "#ffaabb");
		assertEquals(1f, color.r, 0.025f);
		assertEquals(0.666f, color.g, 0.025f);
		assertEquals(0.733f, color.b, 0.025f);
		assertEquals(0.5f, color.a, 0.025f);
	}

}
