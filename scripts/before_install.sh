#!/usr/bin/env bash

PROJECT_ROOT="/home/ubuntu/app"
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +%c)

echo "$TIME_NOW > 기존 파일 삭제" >> $DEPLOY_LOG
rm -rf $PROJECT_ROOT/*.jar

echo "$TIME_NOW > 기존 파일 삭제 완료" >> $DEPLOY_LOG