/**
 * AJAX GET请求
 * @param {string} url - 请求URL
 * @param {function} callback - 成功回调函数
 * @param {function} errorCallback - 错误回调函数
 */
function ajaxGet(url, callback, errorCallback) {
    const xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                const response = JSON.parse(xhr.responseText);
                callback(response);
            } else {
                if (errorCallback) {
                    errorCallback(xhr.status, xhr.responseText);
                } else {
                    showAlert('请求失败，错误码：' + xhr.status, 'danger');
                }
            }
        }
    };
    xhr.send();
}

/**
 * AJAX POST请求
 * @param {string} url - 请求URL
 * @param {object} data - 请求数据
 * @param {function} callback - 成功回调函数
 * @param {function} errorCallback - 错误回调函数
 */
function ajaxPost(url, data, callback, errorCallback) {
    const xhr = new XMLHttpRequest();
    xhr.open('POST', url, true);
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                const response = JSON.parse(xhr.responseText);
                callback(response);
            } else {
                if (errorCallback) {
                    errorCallback(xhr.status, xhr.responseText);
                } else {
                    showAlert('请求失败，错误码：' + xhr.status, 'danger');
                }
            }
        }
    };
    xhr.send(JSON.stringify(data));
}

/**
 * AJAX PUT请求
 * @param {string} url - 请求URL
 * @param {object} data - 请求数据
 * @param {function} callback - 成功回调函数
 * @param {function} errorCallback - 错误回调函数
 */
function ajaxPut(url, data, callback, errorCallback) {
    const xhr = new XMLHttpRequest();
    xhr.open('PUT', url, true);
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                const response = JSON.parse(xhr.responseText);
                callback(response);
            } else {
                if (errorCallback) {
                    errorCallback(xhr.status, xhr.responseText);
                } else {
                    showAlert('请求失败，错误码：' + xhr.status, 'danger');
                }
            }
        }
    };
    xhr.send(JSON.stringify(data));
}

/**
 * AJAX DELETE请求
 * @param {string} url - 请求URL
 * @param {function} callback - 成功回调函数
 * @param {function} errorCallback - 错误回调函数
 */
function ajaxDelete(url, callback, errorCallback) {
    const xhr = new XMLHttpRequest();
    xhr.open('DELETE', url, true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                const response = JSON.parse(xhr.responseText);
                callback(response);
            } else {
                if (errorCallback) {
                    errorCallback(xhr.status, xhr.responseText);
                } else {
                    showAlert('请求失败，错误码：' + xhr.status, 'danger');
                }
            }
        }
    };
    xhr.send();
}

/**
 * 显示提示消息
 * @param {string} message - 消息内容
 * @param {string} type - 消息类型：success, danger, warning
 */
function showAlert(message, type) {
    // 删除已有的alert
    const existingAlerts = document.querySelectorAll('.alert');
    existingAlerts.forEach(alert => {
        alert.remove();
    });
    
    // 创建alert元素
    const alertElement = document.createElement('div');
    alertElement.className = `alert alert-${type}`;
    alertElement.textContent = message;
    
    // 添加到页面
    document.body.appendChild(alertElement);
    
    // 3秒后自动消失
    setTimeout(() => {
        alertElement.remove();
    }, 3000);
}

/**
 * 格式化日期时间
 * @param {string} dateString - 日期字符串
 * @param {boolean} showTime - 是否显示时间
 * @returns {string} 格式化后的日期时间字符串
 */
function formatDate(dateString, showTime = true) {
    if (!dateString) return '';
    
    const date = new Date(dateString);
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    
    if (showTime) {
        const hours = String(date.getHours()).padStart(2, '0');
        const minutes = String(date.getMinutes()).padStart(2, '0');
        const seconds = String(date.getSeconds()).padStart(2, '0');
        return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
    } else {
        return `${year}-${month}-${day}`;
    }
}

/**
 * 打开模态框
 * @param {string} modalId - 模态框ID
 */
function openModal(modalId) {
    const modal = document.getElementById(modalId);
    if (modal) {
        modal.style.display = 'block';
    }
}

/**
 * 关闭模态框
 * @param {string} modalId - 模态框ID
 */
function closeModal(modalId) {
    const modal = document.getElementById(modalId);
    if (modal) {
        modal.style.display = 'none';
    }
}

/**
 * 清空表单数据
 * @param {string} formId - 表单ID
 */
function clearForm(formId) {
    const form = document.getElementById(formId);
    if (form) {
        form.reset();
        // 清除隐藏字段
        const hiddenInputs = form.querySelectorAll('input[type="hidden"]');
        hiddenInputs.forEach(input => {
            input.value = '';
        });
    }
}

/**
 * 填充表单数据
 * @param {string} formId - 表单ID
 * @param {object} data - 数据对象
 */
function fillForm(formId, data) {
    const form = document.getElementById(formId);
    if (form && data) {
        // 遍历表单元素
        Array.from(form.elements).forEach(element => {
            const name = element.name;
            if (name && data[name] !== undefined) {
                if (element.type === 'checkbox') {
                    element.checked = Boolean(data[name]);
                } else if (element.type === 'radio') {
                    element.checked = (element.value === String(data[name]));
                } else if (element.type === 'select-one') {
                    element.value = data[name];
                } else {
                    element.value = data[name];
                }
            }
        });
    }
}

/**
 * 获取表单数据
 * @param {string} formId - 表单ID
 * @returns {object} 表单数据对象
 */
function getFormData(formId) {
    const form = document.getElementById(formId);
    if (!form) return {};
    
    const formData = {};
    
    // 遍历表单元素
    Array.from(form.elements).forEach(element => {
        const name = element.name;
        if (name) {
            if (element.type === 'checkbox') {
                formData[name] = element.checked;
            } else if (element.type === 'radio') {
                if (element.checked) {
                    formData[name] = element.value;
                }
            } else {
                formData[name] = element.value;
            }
        }
    });
    
    return formData;
}

/**
 * 验证表单
 * @param {string} formId - 表单ID
 * @returns {boolean} 验证是否通过
 */
function validateForm(formId) {
    const form = document.getElementById(formId);
    if (!form) return false;
    
    let isValid = true;
    
    // 遍历表单元素
    Array.from(form.elements).forEach(element => {
        if (element.required && !element.value) {
            isValid = false;
            element.classList.add('invalid');
        } else {
            element.classList.remove('invalid');
        }
    });
    
    if (!isValid) {
        showAlert('请填写所有必填字段', 'warning');
    }
    
    return isValid;
}

/**
 * 确认操作
 * @param {string} message - 确认消息
 * @param {function} callback - 确认后的回调函数
 */
function confirmAction(message, callback) {
    if (confirm(message)) {
        callback();
    }
}

/**
 * 检查用户是否登录
 * @returns {boolean} 是否已登录
 */
function checkLogin() {
    const user = sessionStorage.getItem('user');
    return !!user;
}

/**
 * 退出登录
 */
function logout() {
    ajaxPost('/api/user/logout', {}, function(response) {
        if (response.code === 200) {
            sessionStorage.removeItem('user');
            showAlert('退出登录成功', 'success');
            setTimeout(() => {
                window.location.href = 'login.html';
            }, 1000);
        } else {
            showAlert(response.message, 'danger');
        }
    });
}

/**
 * 格式化金额
 * @param {number} amount - 金额
 * @returns {string} 格式化后的金额字符串
 */
function formatAmount(amount) {
    return '¥' + parseFloat(amount).toFixed(2);
}

// 页面加载完成后执行
document.addEventListener('DOMContentLoaded', function() {
    // 关闭模态框事件
    const closeButtons = document.querySelectorAll('.close-button');
    closeButtons.forEach(button => {
        const modalId = button.closest('.modal').id;
        button.addEventListener('click', function() {
            closeModal(modalId);
        });
    });
    
    // 点击模态框外部关闭
    const modals = document.querySelectorAll('.modal');
    modals.forEach(modal => {
        modal.addEventListener('click', function(event) {
            if (event.target === modal) {
                closeModal(modal.id);
            }
        });
    });
});
