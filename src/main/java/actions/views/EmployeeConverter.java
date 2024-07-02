package actions.views;

import java.util.ArrayList;
import java.util.List;

import constants.AttributeConst;
import constants.JpaConst;
import models.Employee;

/**
 * 従業員データのDTOモデル⇔Viewモデルの変換を行うクラス
 *
 */
public class EmployeeConverter {

    /**
     * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
     * @param ev EmployeeViewのインスタンス
     * @return Employeeのインスタンス
     */
    public static Employee toModel(EmployeeView ev) {

        return new Employee(
                ev.getId(),
                ev.getCode(),
                ev.getName(),
                ev.getPassword(),
                ev.getAdminFlag() == null
                        ? null
                                : attribuToJpaAdminFlag(ev.getAdminFlag()), // ここメソッドに置き換え
                ev.getCreatedAt(),
                ev.getUpdatedAt(),
                ev.getDeleteFlag() == null
                ? null
                        : ev.getDeleteFlag() == JpaConst.EMP_DEL_TRUE
                                ? AttributeConst.DEL_FLAG_TRUE.getIntegerValue()
                                : AttributeConst.DEL_FLAG_FALSE.getIntegerValue());
    }

    /**
     * AttributeConstに定義されている管理権限をJpaConstに定義されているものに変換
     * @param auth AttributeConstの権限
     * @return JpaConstの権限
     */
    public static int attribuToJpaAdminFlag(int auth) {

        if(auth == AttributeConst.ROLE_MANAGER.getIntegerValue()) {
            return JpaConst.ROLE_MANAGER;

        } else if (auth == AttributeConst.ROLE_SECTION_CHIEF.getIntegerValue()){
            return JpaConst.ROLE_SECTION_CHIEF;

        }else if (auth == AttributeConst.ROLE_ADMIN.getIntegerValue()){
            return JpaConst.ROLE_ADMIN;

        }else {
            return JpaConst.ROLE_GENERAL;

        }
    }


    /**
     * DTOモデルのインスタンスからViewモデルのインスタンスを作成する
     * @param e Employeeのインスタンス
     * @return EmployeeViewのインスタンス
     */
    public static EmployeeView toView(Employee e) {
        if(e == null) {
            return null;
        }


        return new EmployeeView(
                e.getId(),
                e.getCode(),
                e.getName(),
                e.getPassword(),
                e.getAdminFlag() == null
                        ? null
                                : jpaToAttribuAdminFlag(e.getAdminFlag()),
                e.getCreatedAt(),
                e.getUpdatedAt(),
                e.getDeleteFlag() == null
                        ? null
                        : e.getDeleteFlag() == JpaConst.EMP_DEL_TRUE
                                ? AttributeConst.DEL_FLAG_TRUE.getIntegerValue()
                                : AttributeConst.DEL_FLAG_FALSE.getIntegerValue());
    }
    public static int  jpaToAttribuAdminFlag(int auth) {

        if(auth == JpaConst.ROLE_MANAGER) {
            return AttributeConst.ROLE_MANAGER.getIntegerValue();

        } else if (auth == JpaConst.ROLE_SECTION_CHIEF){
            return AttributeConst.ROLE_SECTION_CHIEF.getIntegerValue();

        }else if (auth == JpaConst.ROLE_ADMIN){
            return AttributeConst.ROLE_ADMIN.getIntegerValue();

        }else {
            return AttributeConst.ROLE_GENERAL.getIntegerValue();

        }
    }
    /**
     * DTOモデルのリストからViewモデルのリストを作成する
     * @param list DTOモデルのリスト
     * @return Viewモデルのリスト
     */
    public static List<EmployeeView> toViewList(List<Employee> list) {
        List<EmployeeView> evs = new ArrayList<>();

        for (Employee e : list) {
            evs.add(toView(e));
        }

        return evs;
    }


    /**
     * Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
     * @param e DTOモデル(コピー先)
     * @param ev Viewモデル(コピー元)
     */
    public static void copyViewToModel(Employee e, EmployeeView ev) {
        e.setId(ev.getId());
        e.setCode(ev.getCode());
        e.setName(ev.getName());
        e.setPassword(ev.getPassword());
        e.setAdminFlag(ev.getAdminFlag());
        e.setCreatedAt(ev.getCreatedAt());
        e.setUpdatedAt(ev.getUpdatedAt());
        e.setDeleteFlag(ev.getDeleteFlag());

    }

}