module hi.f6 {
  requires javafx.controls;
  requires javafx.graphics;
  requires javafx.base;
  requires java.sql;

  opens hi.f6.models to javafx.base;

  exports hi.f6 ;
}
