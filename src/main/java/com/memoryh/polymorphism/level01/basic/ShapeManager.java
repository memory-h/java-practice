package com.memoryh.polymorphism.level01.basic;

import java.util.*;
import java.util.stream.IntStream;

public class ShapeManager {

    private Shape[] shapes = new Shape[10];
    private int index;

    /* 배열에 전달 된 Shape를 추가. 단, 배열의 크기가 부족할 경우 2배로 늘려서 추가. */
    public void addShape(final Shape shape) {
        final int shapeLength = shapes.length;
        if (shapeLength == index) {
            shapes = Arrays.copyOf(shapes, shapeLength * 2);
        }
        shapes[index++] = shape;
    }

    /* 배열에서 전달 된 Shape를 찾아 제거. 단, 제거 된 인덱스가 비어 있지 않도록 뒤에 있는 객체를 앞으로 당김. */
    public void removeShape(final Shape shape) {
        List<Shape> shapeList = new ArrayList<>();
        Collections.addAll(shapeList, shapes);

        for (Shape sh : shapes) {
            if (sh.equals(shape) && sh.hashCode() == shape.hashCode()) {
                shapeList.remove(sh);
                break;
            }
        }
        IntStream.range(0, shapeList.size())
                .forEach(i -> shapes[i] = shapeList.get(i));
    }

    /* 배열에 저장 된 모든 도형의 이름, 넓이, 둘레를 출력 */
    public void printAllShapes() {
        for (Shape shape : shapes) {
            if (shape == null) {
                break;
            }
            System.out.println("Shape: " + shape.getClass().getSimpleName());
            System.out.println("Area: " + shape.calculateArea());
            System.out.println("Perimeter: " + shape.calculatePerimeter());
        }
    }

    /* 배열에 저장 된 모든 도형의 넓이를 더해서 반환 */
    public double getTotalArea() {
        double totalArea = 0d;
        for (Shape shape : shapes) {
            if (shape == null) {
                break;
            }
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }

    /* 배열에 저장 된 모든 도형의 둘레를 더해서 반환 */
    public double getTotalPerimeter() {
        double totalPerimeter = 0d;
        for (Shape shape : shapes) {
            if (shape == null) {
                break;
            }
            totalPerimeter += shape.calculatePerimeter();
        }
        return totalPerimeter;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShapeManager that = (ShapeManager) o;
        return index == that.index && Objects.deepEquals(shapes, that.shapes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(shapes), index);
    }

}