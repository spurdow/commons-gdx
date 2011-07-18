package com.gemserk.commons.gdx.graphics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import com.badlogic.gdx.utils.BufferUtils;

public class Mesh2dBuilder {

	float vertices[];
	float colors[];
	float texCoords[];

	int idxVertices;
	int idxColors;
	int idxTexCoords;

	public Mesh2dBuilder() {
		this(2000);
	}
	
	public Mesh2dBuilder(int maxCount) {
		vertices = new float[maxCount];
		colors = new float[maxCount];
		texCoords = new float[maxCount];
		idxVertices = 0;
		idxColors = 0;
		idxTexCoords = 0;
	}

	public Mesh2dBuilder vertex(float x, float y) {
		vertices[idxVertices++] = x;
		vertices[idxVertices++] = y;
		vertices[idxVertices++] = 0;
		idxColors += 4;
		idxTexCoords += 2;
		return this;
	}

	public Mesh2dBuilder color(float r, float g, float b, float a) {
		colors[idxColors] = r;
		colors[idxColors + 1] = g;
		colors[idxColors + 2] = b;
		colors[idxColors + 3] = a;
		return this;
	}

	public Mesh2dBuilder texCoord(float u, float v) {
		texCoords[idxTexCoords] = u;
		texCoords[idxTexCoords + 1] = v;
		return this;
	}

	public Mesh2d build() {
		Mesh2d mesh2d = new Mesh2d();

		mesh2d.setVertexArray(allocateBuffer(3 * idxVertices));
		mesh2d.setColorArray(allocateBuffer(4 * idxColors));
		mesh2d.setTexCoordArray(allocateBuffer(2 * idxColors));

		BufferUtils.copy(vertices, mesh2d.getVertexArray(), idxVertices, 0);
		BufferUtils.copy(colors, mesh2d.getColorArray(), idxColors, 0);
		BufferUtils.copy(texCoords, mesh2d.getTexCoordArray(), idxTexCoords, 0);

		idxVertices = 0;
		idxColors = 0;
		idxTexCoords = 0;

		return mesh2d;
	}
	
	private FloatBuffer allocateBuffer(int numFloats) {
		ByteBuffer buffer = ByteBuffer.allocateDirect(numFloats * 4);
		buffer.order(ByteOrder.nativeOrder());
		return buffer.asFloatBuffer();
	}

}