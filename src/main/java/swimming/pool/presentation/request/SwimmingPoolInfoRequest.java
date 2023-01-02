package swimming.pool.presentation.request;

import swimming.pool.application.command.RegisterSwimmingPoolCommand;
public class SwimmingPoolInfoRequest {

  private String lastmodts;
  private String culphyedcobnm;
  private String dtlstatenm; // swimming pool state
  private String bdngyarea;
  private String puprsenm;
  private String bplcnm; // swimming pool name
  private String clgenddt;
  private String sitearea;
  private String dcbymd;
  private String clgstdt;
  private String trdstategbn;
  private String trdstatenm;
  private String apvcancelymd;
  private String sitepostno;
  private String opnsfteamcode;
  private String sitetel;
  private String sitewhladdr; // 지번 주소
  private String dtlstategbn;
  private String rdnpostno;
  private String updategbn;
  private String updatedt;
  private String apvpermymd;
  private String uptaenm;
  private String rdnwhladdr; // 도로명 주소
  private String drmkcobnm;
  private String memcolltotstfnum;
  private String bupnm;
  private String bdngdngnum;
  private String ldercnt;
  private String insurjnyncode;
  private String y;
  private String ropnymd;
  private String mgtno;
  private String x;

  public RegisterSwimmingPoolCommand toCommand() {
    return new RegisterSwimmingPoolCommand(
        this.bplcnm,
        this.dtlstatenm,
        this.sitewhladdr,
        this.rdnwhladdr
    );
  }

  public SwimmingPoolInfoRequest() {
  }

  public String getDtlstatenm() {
    return dtlstatenm;
  }

  public String getBplcnm() {
    return bplcnm;
  }

  public String getSitewhladdr() {
    return sitewhladdr;
  }

  public String getRdnwhladdr() {
    return rdnwhladdr;
  }
}
