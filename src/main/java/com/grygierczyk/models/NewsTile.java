package com.grygierczyk.models;

public class NewsTile {
  private static int nextId = 0;
  private int id;
  private String header;
  private String text;
  private byte[] imageBytes;

  public NewsTile(String header, String text, byte[] imageBytes) {
    this.id = nextId++;
    this.header = header;
    this.text = text;
    this.imageBytes = imageBytes;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public byte[] getImageBytes() {
    return imageBytes;
  }

  public void setImageBytes(byte[] imageBytes) {
    this.imageBytes = imageBytes;
  }
}
