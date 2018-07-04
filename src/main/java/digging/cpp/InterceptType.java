/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package digging.cpp;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum InterceptType implements org.apache.thrift.TEnum {
  GRE(1),
  LEGAL(2),
  DNS(3),
  OTHER(4);

  private final int value;

  private InterceptType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static InterceptType findByValue(int value) { 
    switch (value) {
      case 1:
        return GRE;
      case 2:
        return LEGAL;
      case 3:
        return DNS;
      case 4:
        return OTHER;
      default:
        return null;
    }
  }
}
