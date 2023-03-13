package gameSnake;

import java.awt.Point;

public class ular {
    //*********************//
  //*** Variable area ***//
  //*********************//
  // coordinates of body
  private Point[] body;
  // facing
  private int face;

  // maximum snake's length
  private final int maxLength = 10;

  // orientation
  public static final int NORTH = 0;
  public static final int EAST = 1;
  public static final int SOUTH = 2;
  public static final int WEST = 3;

  // snake pixel size
  public static final int SNAKE_SIZE = 10;

  //************************//
  //*** Constructor area ***//
  //************************//
  public ular() {
    body = new Point[maxLength];
    for(int i = 0; i < maxLength; i++) {
      body[i] = new Point(20 - i, 15);
    }
    face = EAST;
  }

  //*******************//
  //*** Method area ***//
  //*******************//
  public Point[] getBody() {
    return body;
  }

  public void moveEast() {
    if(face != WEST)
      face = EAST;
  }

  public void moveWest() {
    if(face != EAST)
      face = WEST;
  }

  public void moveNorth() {
    if(face != SOUTH)
      face = NORTH;
  }

  public void moveSouth() {
    if(face != NORTH)
      face = SOUTH;
  }

  public void update() {
    // update body
    for(int i = body.length - 1; i > 0; i--) {
      body[i].x = body[i-1].x;
      body[i].y = body[i-1].y;
    }
    // update head
    Point head = body[0];
    if(face == NORTH) {
      if(head.y <= 0)
        head.y = snake.AREA_HEIGHT - 1;
      else
        head.y--;
    }
    else if(face == EAST) {
      if(head.x >= snake.AREA_WIDTH - 1)
        head.x = 0;
      else
        head.x++;
    }
    else if(face == SOUTH) {
      if(head.y >= snake.AREA_HEIGHT - 1)
        head.y = 0;
      else
        head.y++;
    }
    else if(face == WEST) {
      if(head.x <= 0)
        head.x = snake.AREA_WIDTH - 1;
      else
        head.x--;
    }
  }
}
