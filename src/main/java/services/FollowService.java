package services;

import java.util.List;

import actions.views.EmployeeConverter;
import actions.views.EmployeeView;
import actions.views.FollowConverter;
import actions.views.FollowView;
import constants.JpaConst;
import models.Follow;

public class FollowService extends ServiceBase {

    public List<String> create(FollowView fv) {

        createInternal(fv);

        //バリデーションで発生したエラーを返却（エラーがなければ0件の空リスト）
        return null;
    }

    private void createInternal(FollowView fv) {

        em.getTransaction().begin();
        em.persist(FollowConverter.toModel(fv));
        em.getTransaction().commit();

    }
    /**
     * 指定した従業員が作成した日報データを、指定されたページ数の一覧画面に表示する分取得しReportViewのリストで返却する
     * @param employee 従業員
     * @param page ページ数
     * @return 一覧画面に表示するデータのリスト
     */
    public List<FollowView> getFollowList(EmployeeView employee) {

        List<Follow> follows = em.createNamedQuery(JpaConst.Q_FOL_GET_FOLLOWED, Follow.class)
                .setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
                .getResultList();
        return FollowConverter.toViewList(follows);
    }
    /**
     * 日報テーブルのデータの件数を取得し、返却する
     * @return データの件数s
     */
    public long countAll() {
        long follows_count = (long) em.createNamedQuery(JpaConst.Q_REP_COUNT, Long.class)
                .getSingleResult();
        return follows_count;

    }
    /**
     * idを条件に取得したデータをFollowViewのインスタンスで返却する
     * @param id
     * @return 取得データのインスタンス
     */
    public FollowView findOne(int id) {
        return FollowConverter.toView(findOneInternal(id));
    }
    /**
     * idを条件にデータを1件取得する
     * @param id
     * @return 取得データのインスタンス
     */
    private Follow findOneInternal(int id) {
        return em.find(Follow.class, id);
    }

}
