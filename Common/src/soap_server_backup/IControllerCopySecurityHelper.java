package soap_server_backup;


/**
* soap_server_backup/IControllerCopySecurityHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from IServerBackup.idl
* Monday, August 8, 2022 10:20:54 AM COT
*/

abstract public class IControllerCopySecurityHelper
{
  private static String  _id = "IDL:soap_server_backup/IControllerCopySecurity:1.0";

  public static void insert (org.omg.CORBA.Any a, soap_server_backup.IControllerCopySecurity that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static soap_server_backup.IControllerCopySecurity extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (soap_server_backup.IControllerCopySecurityHelper.id (), "IControllerCopySecurity");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static soap_server_backup.IControllerCopySecurity read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_IControllerCopySecurityStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, soap_server_backup.IControllerCopySecurity value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static soap_server_backup.IControllerCopySecurity narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof soap_server_backup.IControllerCopySecurity)
      return (soap_server_backup.IControllerCopySecurity)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      soap_server_backup._IControllerCopySecurityStub stub = new soap_server_backup._IControllerCopySecurityStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static soap_server_backup.IControllerCopySecurity unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof soap_server_backup.IControllerCopySecurity)
      return (soap_server_backup.IControllerCopySecurity)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      soap_server_backup._IControllerCopySecurityStub stub = new soap_server_backup._IControllerCopySecurityStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
