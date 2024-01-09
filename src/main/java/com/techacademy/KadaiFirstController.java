package com.techacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController                     //@RestController:REST用のHTTPリクエストを受け付けるクラスであることを示す
public class KadaiFirstController {

    //仕様1:指定日の曜日を算定する
    @GetMapping("/dayofweek/{val2}")      //@GetMapping:HTTPリクエストのGETメソッドを受け取る関数
    public String dispDayOfWeek(@PathVariable String val2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");//日付フォーマットを登録する
        LocalDate localdate = LocalDate.parse(val2, formatter);//Stringで受け取った日付をyyyyMMdd形式の日付オブジェクトに変換
        DayOfWeek dayofweek = localdate.getDayOfWeek();//曜日を扱うクラス
        return "実行結果：" + dayofweek;
    }
    //仕様2:四則演算を行う
    //足し算
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {//@PathVariable:変数の取得
        int res = 0;
        res = val1 + val2;
        return "実行結果：" + res;
    }
    //引き算
    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "実行結果：" + res;
    }
    //掛け算
    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "実行結果：" + res;
    }
    //割り算
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "実行結果：" + res;
    }

}

