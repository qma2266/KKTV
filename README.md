# KKTV
## Question1 

### Feature
| 測試類型 | Unit Tests     | Feature Tests      |
| ---------- | :-----------:  | :-----------: |
| 執行測試人員     |RD     | SQA     |

### Develop
| 測試類型 | Integration Test     | Compatibility Test      |
| ---------- | :-----------:  | :-----------: |
| 執行測試人員     |SQA     | SQA     |

### Release 
| 測試類型 | Stress Testing   | Acceptance Tests     |
| ---------- | :-----------:  | :-----------: |
| 執行測試人員     |SQA     | SQA     |

### Hotfix   分支
| 測試類型 | Unit Tests     | Integration Test     | Stress Tests     |Acceptance Tests|
| ---------- | :-----------:  | :-----------: |:-----------: |:-----------: |
| 執行測試人員     |RD     | RD     |SQA    |SQA    

### Master  分支
> 在 Release 或 Hotfix 已確保 **問題** 都被解決，才會 Commit 到 Master 
> 故在 Master 應不會有任何的測試，是最後出版的版本
