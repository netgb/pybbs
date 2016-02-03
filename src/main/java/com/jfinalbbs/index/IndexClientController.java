package com.jfinalbbs.index;

import com.jfinal.plugin.activerecord.Page;
import com.jfinalbbs.common.BaseController;
import com.jfinalbbs.topic.Topic;

/**
 * Created by Tomoya.
 * Copyright (c) 2016, All Rights Reserved.
 * http://jfinalbbs.com
 */
public class IndexClientController extends BaseController {

    public void index() {
        String tab = getPara("tab");
        String q = getPara("q");
        if (tab == null) tab = "all";
        Page<Topic> page = Topic.me.paginate(getParaToInt("p", 1),
                getParaToInt("size", defaultPageSize()), tab, q, 1, null);
        success(page);
    }
}