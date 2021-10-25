package miam;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws BareBonesException {
    Parser parser = new Parser(args[0]);
    try {
      Transpiler.Pi(parser, "bareBones/main.py");
    } catch (IOException e) {
      throw new BareBonesException("Could not write formatted file.");
    }
    try {
      Transpiler.Format(parser, "bareBones/format.bb");
    } catch (IOException e) {
      throw new BareBonesException("Could not write formatted file.");
    }
    try {
      Transpiler.Java(parser, "bareBones/Main.java");
    } catch (IOException e) {
      throw new BareBonesException("Could not write formatted file.");
    }
    try {
      Transpiler.Rust(parser, "bareBones/main.rs");
    } catch (IOException e) {
      throw new BareBonesException("Could not write formatted file.");
    }
    try {
      Transpiler.CPP(parser, "bareBones/main.cpp");
    } catch (IOException e) {
      throw new BareBonesException("Could not write formatted file.");
    }
    Interpreter interpreter = new Interpreter(parser);
    interpreter.start();
  }
}
