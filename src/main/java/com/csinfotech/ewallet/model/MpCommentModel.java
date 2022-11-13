package com.csinfotech.ewallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_comments")
public class MpCommentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int c_id;
    private int c_mp_id;
    private String c_date;
    private String c_username;
    private String c_phone_no;
    private String c_image;
    private String c_comment;

}
