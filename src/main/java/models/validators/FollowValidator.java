package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.FollowView;
import constants.MessageConst;

/**
 * フォローインスタンスに設定されている値のバリデーションを行うクラス
 */
public class FollowValidator {

    /**
     * フォローインスタンスの各項目についてバリデーションを行う
     * @param fv フォローインスタンス
     * @return エラーのリスト
     */
    public static List<String> validate(FollowView fv) {
        List<String> errors = new ArrayList<String>();

//        //フォローのチェック
//        String followError = validate(fv.getFollower_id());
//        if (!followError.equals("")) {
//            errors.add(followError);
//        }
//      //社員番号のチェック
//        String codeError = validateCode(service, ev.getCode(), codeDuplicateCheckFlag);
//        if (!codeError.equals("")) {
//            errors.add(codeError);
//        }
//
//        //内容のチェック
//        String contentError = validateContent(fv.getContent());
//        if (!contentError.equals("")) {
//            errors.add(contentError);
//        }

        return errors;
    }

    /**
     * タイトルに入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param title タイトル
     * @return エラーメッセージ
     */
    private static String validateTitle(String title) {
        if (title == null || title.equals("")) {
            return MessageConst.E_NOTITLE.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 内容に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param content 内容
     * @return エラーメッセージ
     */
    private static String validateContent(String content) {
        if (content == null || content.equals("")) {
            return MessageConst.E_NOCONTENT.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }
}