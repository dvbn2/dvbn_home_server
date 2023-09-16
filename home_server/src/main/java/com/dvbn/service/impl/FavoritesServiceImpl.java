package com.dvbn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dvbn.domain.Favorites;
import com.dvbn.mapper.FavoritesMapper;
import com.dvbn.service.FavoritesService;
import org.springframework.stereotype.Service;

/**
 * @author dvbn
 * @description 针对表【favorites(收藏表)】的数据库操作Service实现
 * @createDate 2023-09-16 19:16:02
 */
@Service
public class FavoritesServiceImpl extends ServiceImpl<FavoritesMapper, Favorites>
        implements FavoritesService {

}




