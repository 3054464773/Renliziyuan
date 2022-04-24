//package com.trkj.renliziyuangl.pojo;
//
//import com.alibaba.fastjson.annotation.JSONField;
//import com.trkj.pojo.Userb;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Data
//@NoArgsConstructor
//public class LoginUser implements UserDetails {
//    private Userb userb;
//    private List<String> quanxian;
//
//    public LoginUser(Userb userb, List<String> quanxian) {
//        this.userb = userb;
//        this.quanxian = quanxian;
//    }
//    @JSONField(serialize = false)
//    private  List<GrantedAuthority> qxlist;
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//       if (qxlist==null){
//           qxlist=new ArrayList<>();
//           for (String qx : quanxian) {
//               SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(qx);
//               qxlist.add(simpleGrantedAuthority);
//           }
//       }
//        return qxlist;
//    }
//
//    @Override
//    public String getPassword() {
//        return userb.getUmm();
//    }
//
//    @Override
//    public String getUsername() {
//        return userb.getUname();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
