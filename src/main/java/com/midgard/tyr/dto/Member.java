package com.midgard.tyr.dto;

import com.midgard.tyr.config.security.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * description    :
 * packageName    : com.midgard.tyr.dto
 * fileName       : Member
 * author         : sangeui.lee
 * date           : 2022-12-26
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-26        sangeui.lee       최초 생성
 */
@Getter
@Setter
@ToString
public class Member implements Serializable {

    public String id;

    public String password;

    public Role role;

    public boolean enabled;


}
