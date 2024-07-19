package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * フォローデータのDTOモデル
 *
 */
@Table(name = JpaConst.TABLE_FOL)
@NamedQueries({
//    @NamedQuery(
//            name = JpaConst.Q_FOL_GET_ALL,
//            query = JpaConst.Q_FOL_GET_ALL_DEF),
//    @NamedQuery(
//            name = JpaConst.Q_FOL_GET_ALL_FOLLOWER,
//            query = JpaConst.Q_FOL_GET_ALL_FOLLOWER_DEF),
    @NamedQuery(
            name = JpaConst.Q_FOL_GET_FOLLOWED,
            query = JpaConst.Q_FOL_GET_FOLLOWED_DEF),

})

@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
@Entity
public class Follow {

    /**
     * id
     */
    @Id
    @Column(name = JpaConst.FOL_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * follower_id
     */
    @ManyToOne
    @JoinColumn(name = JpaConst.FOL_COL_FOLLOWER_ID, nullable = false)
    private Employee follower;

    /**
     * employee_id
     */
    @ManyToOne
    @JoinColumn(name = JpaConst.FOL_COL_EMPLOYEE_ID, nullable = false)
    private Employee employee;
}