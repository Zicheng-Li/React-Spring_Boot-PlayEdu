/*
 * Copyright 2023 杭州白书科技有限公司
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package xyz.playedu.api.checks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import xyz.playedu.api.constant.BackendConstant;
import xyz.playedu.api.domain.AdminRole;
import xyz.playedu.api.service.AdminRoleService;

import java.util.Date;

/**
 * @Author 杭州白书科技有限公司
 *
 * @create 2023/2/23 22:09
 */
@Component
public class AdminRoleCheck implements ApplicationRunner {

    @Autowired private AdminRoleService adminRoleService;

    private static final AdminRole superRole =
            new AdminRole() {
                {
                    setName("超级管理员");
                    setSlug(BackendConstant.SUPER_ADMIN_ROLE);
                    setCreatedAt(new Date());
                    setCreatedAt(new Date());
                }
            };

    @Override
    public void run(ApplicationArguments args) throws Exception {
        AdminRole adminRole = adminRoleService.getBySlug(BackendConstant.SUPER_ADMIN_ROLE);
        if (adminRole != null) { // 已存在超级管理权限
            return;
        }
        adminRoleService.save(superRole);
    }
}
