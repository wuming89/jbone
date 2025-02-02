package cn.jbone.cms.portal.service;

import cn.jbone.cms.api.TagApi;
import cn.jbone.cms.common.dataobject.TagDO;
import cn.jbone.cms.portal.manager.SiteManager;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagApi tagApi;

    @Autowired
    private SiteManager siteManager;
    public List<TagDO> findTagCloud(){
        Result<List<TagDO>> result = tagApi.findTagCloud(siteManager.getCurrentSiteId());
        if(result != null && result.isSuccess()){
            return result.getData();
        }
        return null;
    }

    public TagDO findById(Long id){
        Result<TagDO> result = tagApi.getById(id);
        if(result != null && result.isSuccess()){
            return result.getData();
        }
        return null;
    }
}
