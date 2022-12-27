package swimming.pool.location;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.locationtech.proj4j.CRSFactory;
import org.locationtech.proj4j.CoordinateReferenceSystem;
import org.locationtech.proj4j.CoordinateTransform;
import org.locationtech.proj4j.CoordinateTransformFactory;
import org.locationtech.proj4j.ProjCoordinate;

public class LocationProj4jTest {

  /*
  CRSFactory crsFactory;
  Position middleTmPosition;
  */

  @BeforeEach
  void setUp() {
    // crsFactory = new CRSFactory();
    // middleTmPosition = new Position(208330.35418254, 456814.922480529); // bessel
  }

  /*
  @Test
  public void transformLocationInformationTest() throws Exception {
    // given
    //  +towgs84=-115.80,474.99,674.11,1.16,-2.31,-1.63,6.43
    CoordinateReferenceSystem middleSideLocationTM = crsFactory.createFromParameters("Bessel",
        "+proj=tmerc +lat_0=38 +lon_0=127 +k=1 +x_0=200000 +y_0=500000 +ellps=bessel +towgs84=-145.907,505.034,685.756,-1.162,2.347,1.592,6.342 +units=m +no_defs +type=crs");
    CoordinateReferenceSystem WGS84 = crsFactory.createFromParameters("WGS84",
        "+proj=longlat +ellps=WGS84 +datum=WGS84 +no_defs");

    // when
    CoordinateTransformFactory ctFactory = new CoordinateTransformFactory();
    CoordinateTransform middleTMToWGS = ctFactory.createTransform(middleSideLocationTM, WGS84);

    // then
    ProjCoordinate result = new ProjCoordinate();
    middleTMToWGS.transform(
        new ProjCoordinate(middleTmPosition.getxPos(), middleTmPosition.getyPos()), result);

    // want (xPox, yPos) = (37.614726, 127.090860)
    assertThat(result.x).isEqualTo(37.614726);
//    Assertions.assertThat(transformData.y).isEqualTo(127.090860);
  }
  */

  /*
  @Test
  public void transformESPG2097ToWGS84LocationTest() throws Exception {
    // given
    ProjCoordinate inputCoordinate = new ProjCoordinate(middleTmPosition.getxPos(),
        middleTmPosition.getyPos());

    // when
    CoordinateReferenceSystem sourceProjection = crsFactory.createFromParameters("Bessel",
        "+proj=tmerc +lat_0=38 +lon_0=127 +k=1 +x_0=200000 +y_0=500000 +ellps=bessel +units=m +no_defs +towgs84=-115.80,474.99,674.11,1.16,-2.31,-1.63,6.43");
    CoordinateReferenceSystem targetProjection = crsFactory.createFromParameters("WGS84",
        "+proj=longlat +ellps=WGS84 +datum=WGS84 +no_defs");

    *//*CoordinateReferenceSystem sourceProjection = crsFactory.createFromName("EPSG:2097");
    CoordinateReferenceSystem targetProjection = crsFactory.createFromName("EPSG:4326");*//*

    CoordinateTransformFactory ctFactory = new CoordinateTransformFactory();
    CoordinateTransform transform = ctFactory.createTransform(sourceProjection, targetProjection);

    ProjCoordinate outputCoordinate = new ProjCoordinate();
    transform.transform(inputCoordinate, outputCoordinate);

    // then
    // want (xPox, yPos) = (37.614726, 127.090860)
    assertThat(outputCoordinate.x).isEqualTo(37.614726);
  }
  */

  private class Position {

    private double xPos;
    private double yPos;

    public Position(double xPos, double yPos) {
      this.xPos = xPos;
      this.yPos = yPos;
    }

    public double getxPos() {
      return xPos;
    }

    public double getyPos() {
      return yPos;
    }
  }

}
